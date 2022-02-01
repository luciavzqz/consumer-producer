package com.producerconsumer.using_blocking_queue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    BlockingQueue<Integer> questionQueue;

    /**
     * The consumer answers questions from the questionQueue, added by the producer, and then remove them off of the list.
     */
    public Consumer(BlockingQueue<Integer> questionQueue){
        this.questionQueue = questionQueue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " answered question: " + questionQueue.take());
            } catch (InterruptedException e) {
            }
        }
    }
}
