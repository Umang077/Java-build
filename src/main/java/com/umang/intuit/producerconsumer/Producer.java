package com.umang.intuit.producerconsumer;

public class Producer implements Runnable {

    private final SharedBuffer<Integer> buffer;

    public Producer(SharedBuffer<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                buffer.produce(i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
