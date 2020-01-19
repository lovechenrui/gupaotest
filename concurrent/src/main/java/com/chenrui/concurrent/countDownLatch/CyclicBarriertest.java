package com.chenrui.concurrent.countDownLatch;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 与countDownLatch相反，做加法，所有人到齐，开始开会
 */
public class CyclicBarriertest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier= new CyclicBarrier(3,()->{
            System.out.println("人到齐，开始开会");
        });
        for (int i = 0; i < 7 ; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"已到，等待。。。");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
            System.out.println();
        }
    }

}
