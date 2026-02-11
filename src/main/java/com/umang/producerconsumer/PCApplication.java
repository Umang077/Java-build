//package com.umang.intuit.producerconsumer;
//
//public class PCApplication {
//
//    public static void main(String[] args) {
//
//        SharedBuffer<Integer> buffer = new SharedBuffer<>(5);
//
//        Thread producer1 = new Thread(new Producer(buffer), "Producer-1");
//        Thread consumer1 = new Thread(new Consumer(buffer), "Consumer-1");
//
//        producer1.start();
//        consumer1.start();
//    }
//}


//use the manual creation of thread which can be expensive
//package com.umang.intuit.producerconsumer;
//
//public class PCApplication {
//
//    public static void main(String[] args) {
//
//        SharedBuffer<Integer> buffer = new SharedBuffer<>(5);
//
//        Thread producer1 = new Thread(new Producer(buffer), "Producer-1");
//        Thread producer2 = new Thread(new Producer(buffer), "Producer-2");
//
//        Thread consumer1 = new Thread(new Consumer(buffer), "Consumer-1");
//        Thread consumer2 = new Thread(new Consumer(buffer), "Consumer-2");
//
//        producer1.start();
//        producer2.start();
//        consumer1.start();
//        consumer2.start();
//    }
//}

package com.umang.producerconsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PCApplication {

    public static void main(String[] args) {

        SharedBuffer<Integer> buffer = new SharedBuffer<>(5);

        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(new Producer(buffer));
        executor.submit(new Producer(buffer));

        executor.submit(new Consumer(buffer));
        executor.submit(new Consumer(buffer));

        executor.shutdown();
    }
}
