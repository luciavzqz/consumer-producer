package com.producerconsumer.using_notify_wait;

import java.util.List;

public class Consumer implements Runnable {

    List<Integer> questionList = null;

    /**
     * The consumer answers questions from the @questionList, added by the producer, and then remove them off of the list.
     */
    public Consumer(List<Integer> questionList){
        this.questionList = questionList;
    }

    public void answerQuestion() throws InterruptedException {
        synchronized (questionList) {
            while(questionList.isEmpty()) {
                System.out.println("No Question to Answer... Waiting for producer to get questions.");
                questionList.wait();
            }
        }

        synchronized (questionList) {
            Thread.sleep(5000);
            System.out.println("Answered Question: " + questionList.remove(0));
            questionList.notify();
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                answerQuestion();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
