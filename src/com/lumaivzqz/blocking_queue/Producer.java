package com.lumaivzqz.blocking_queue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    BlockingQueue<Integer> questionQueue;
    private int questionNo;

    /**
     * The producer is adding to the list up to the limit of the queue and then has to wait until the consumer answers those
     * questions and then remove them off of the list.
     */
    public Producer(BlockingQueue<Integer> questionQueue){
        this.questionQueue = questionQueue;
    }

    @Override
    public void run() {
        while(true) {
            try {
                synchronized (this) {
                    int nextQuestion = questionNo++;
                    System.out.println("Got new question: " + nextQuestion);
                    questionQueue.put(nextQuestion);
                }
            } catch (InterruptedException e) {
            }
        }
    }
}
