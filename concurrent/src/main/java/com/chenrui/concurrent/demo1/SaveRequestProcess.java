package com.chenrui.concurrent.demo1;

import java.util.concurrent.LinkedBlockingQueue;

public class SaveRequestProcess extends Thread implements RequestProcess {
    LinkedBlockingQueue<Request> linkedBlockingQueue = new LinkedBlockingQueue<Request>();
    @Override
    public void run() {
        while (true){
            try {
                System.out.println("save start....");
                Request request = linkedBlockingQueue.take();
                System.out.println("save request:"+request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void processRequest(Request request) {
        linkedBlockingQueue.add(request);
    }
}
