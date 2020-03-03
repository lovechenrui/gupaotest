package com.chenrui.concurrent.demo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ThreadA implements Runnable {
    private Lock  lock ;
    private Condition condition;
    public ThreadA(Lock lock,Condition condition){
        this.lock =lock;
        this.condition =condition;
    }
    @Override
    public void run() {

        try {
            lock.lock();
            System.out.println("ThreadA获取到线程");
            condition.await();
            System.out.println("ThreadA阻塞");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
