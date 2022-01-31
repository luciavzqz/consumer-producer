package com.lumaivzqz.notify_wait;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        List<Integer> questionList = new ArrayList<>();

        Thread producerThread = new Thread(new Producer(questionList));
        Thread consumerThread = new Thread(new Consumer(questionList));

        producerThread.start();
        consumerThread.start();
    }
}
