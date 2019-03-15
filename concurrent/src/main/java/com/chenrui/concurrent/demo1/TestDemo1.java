package com.chenrui.concurrent.demo1;

public class TestDemo1 {
    PrintRequestProcess printRequestProcess;
    public TestDemo1(){
        SaveRequestProcess saveRequestProcess = new SaveRequestProcess();
        saveRequestProcess.start();
        printRequestProcess = new PrintRequestProcess(saveRequestProcess);
        printRequestProcess.start();
    }
    public static void main(String[] args) {
        Request request = new Request();
        request.setName("chenrui");
        new TestDemo1().doTest(request);
    }

    public void doTest(Request request){
        printRequestProcess.processRequest(request);
    }
}
