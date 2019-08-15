package com.chenrui.concurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;


public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
//        nightStudy();
        countryQI();
    }

    /**
     * 6个人上自习，班长最后走人关门
     */
    private static void nightStudy() throws InterruptedException {
        CountDownLatch countDownLatch =new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"上完自习走人");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"班长关门走人");
    }

    /**
     * 齐灭六国
     * @throws InterruptedException
     */
    private static void countryQI() throws InterruptedException {
        CountDownLatch countDownLatch =new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"国被灭");
                countDownLatch.countDown();
            },CountryEnum.search_country(i).getName()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"秦统一六国");
    }
}
