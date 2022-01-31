package com.lumaivzqz.blocking_queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Application {
    final static int LIMIT = 5;

    public static void main(String[] args) {
        BlockingQueue<Integer> questionQueue = new ArrayBlockingQueue<>(LIMIT);

        Thread producerThread = new Thread(new Producer(questionQueue));
        Thread consumerThread1 = new Thread(new Consumer(questionQueue));
        Thread consumerThread2 = new Thread(new Consumer(questionQueue));

        producerThread.start();
        consumerThread1.start();
        consumerThread2.start();
    }
}
