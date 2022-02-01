package com.producerconsumer.using_notify_wait;

import java.util.List;

public class Producer implements Runnable{

    List<Integer> questionList;
    final int LIMIT = 5;
    private int questionNo;

    /**
     * The producer is adding to the list up to the limit of five and then has to wait until the consumer answers those
     * questions and then remove them off of the list.
     */
    public Producer(List<Integer> questionList){
        this.questionList = questionList;
    }

    public void readQuestion(int questionNo) throws InterruptedException {
        synchronized (questionList) {
            while(questionList.size() == LIMIT) {
                System.out.println("Questions have pilled up... wait for answers.");
                questionList.wait();
            }
        }

        synchronized (questionList) {
            System.out.println("New question: " + questionNo);
            questionList.add(questionNo);
            Thread.sleep(100);
            questionList.notifyAll();
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                readQuestion(questionNo++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
