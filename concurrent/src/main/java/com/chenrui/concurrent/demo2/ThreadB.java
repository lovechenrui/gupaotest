package com.chenrui.concurrent.demo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class ThreadB implements Runnable {
    private Lock  lock ;
    private Condition condition;
    public ThreadB(Lock lock, Condition condition){
        this.lock =lock;
        this.condition =condition;
    }
    @Override
    public void run() {

        try {
            lock.lock();
            System.out.println("ThreadB获取到线程");
            condition.signal();
            System.out.println("ThreadB阻塞");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
