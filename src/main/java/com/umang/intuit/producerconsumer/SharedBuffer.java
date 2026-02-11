package com.umang.intuit.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer<T> {

    private final Queue<T> buffer;
    private final int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
        this.buffer = new LinkedList<>();
    }

    public synchronized void produce(T item) throws InterruptedException {
        while (buffer.size() == capacity) {
            System.out.println("Buffer full, producer waiting...");
            wait();
        }

        buffer.add(item);
        System.out.println(Thread.currentThread().getName() + " produced: " + item);

        notifyAll();
    }

    public synchronized T consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            System.out.println("Buffer empty, consumer waiting...");
            wait();
        }

        T item = buffer.poll();
        System.out.println(Thread.currentThread().getName() + " consumed: " + item);

        notifyAll();

        return item;
    }
}
