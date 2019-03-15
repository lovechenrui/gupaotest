package com.chenrui.concurrent.demo1;

import java.util.concurrent.LinkedBlockingQueue;

public class PrintRequestProcess extends  Thread implements RequestProcess {
    LinkedBlockingQueue<Request> linkedBlockingQueue = new LinkedBlockingQueue<Request>();

    private final RequestProcess requestProcess;

    public PrintRequestProcess(RequestProcess requestProcess){
        this.requestProcess = requestProcess;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("save start....");
                Request request = linkedBlockingQueue.take();
                System.out.println("print request:"+request);
                requestProcess.processRequest(request);
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
