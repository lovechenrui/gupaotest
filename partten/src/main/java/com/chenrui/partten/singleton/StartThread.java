package com.chenrui.partten.singleton;

import java.util.concurrent.CountDownLatch;

public class StartThread {
	public static long startTaskInOnce(int threadNum, final Runnable task){
		long starttime = System.currentTimeMillis();
		//创建开始门
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(threadNum);
		for(int i=0;i<threadNum;i++){
			Thread thread = new Thread(){
				@Override
				public void run() {
					try {
						//线程在此处等待
						startGate.await();
						task.run();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally {
						//结束门 -1
						endGate.countDown();
					}
				}
			};
			thread.start();
		}
		//发令枪，开始执行
		startGate.countDown();
		try {
			//所有的线程都执行了
			endGate.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endtime = System.currentTimeMillis();
		return endtime - starttime;
	}
}
