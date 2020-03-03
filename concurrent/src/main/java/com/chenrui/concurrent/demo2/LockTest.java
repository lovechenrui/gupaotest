package com.chenrui.concurrent.demo2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        ThreadA threadA = new ThreadA(lock,condition);
        ThreadB threadB = new ThreadB(lock,condition);
        new Thread(threadA).start();
        new Thread(threadB).start();

    }
}
