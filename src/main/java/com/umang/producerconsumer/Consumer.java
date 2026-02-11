package com.umang.producerconsumer;

public class Consumer implements Runnable {

    private final SharedBuffer<Integer> buffer;

    public Consumer(SharedBuffer<Integer> buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                buffer.consume();
                Thread.sleep(800);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
