package com.umang.intuit.producerconsumer;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SharedBufferTest {

    @Test
    void shouldProduceAndConsumeCorrectly() throws InterruptedException {

        SharedBuffer<Integer> buffer = new SharedBuffer<>(2);

        buffer.produce(1);
        buffer.produce(2);

        assertEquals(1, buffer.consume());
        assertEquals(2, buffer.consume());
    }

    @Test
    void shouldRespectCapacityLimit() throws InterruptedException {

        SharedBuffer<Integer> buffer = new SharedBuffer<>(1);

        buffer.produce(10);
        assertEquals(10, buffer.consume());
    }
}
