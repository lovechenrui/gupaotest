package com.chenrui.concurrent.deadLock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 死锁demo
 */
public class DeadLockDemo {
	static class InnerDeadLock implements Runnable {
		private DeadLockDemo locka;
		private DeadLockDemo lockb;


		public InnerDeadLock(DeadLockDemo locka, DeadLockDemo lockb) {
			this.locka = locka;
			this.lockb = lockb;
		}
		@Override
		public void run() {
			while(true) {
				synchronized (locka) {
					System.out.println(Thread.currentThread().getName() + "获取锁");
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized (lockb) {
						System.out.println(Thread.currentThread().getName() + "等待锁");
					}
				}
			}
		}
	}
	public static void main(String[] args) {

		LinkedBlockingQueue linkedBlockingQueue =new LinkedBlockingQueue(5);
		linkedBlockingQueue.add("");
//		linkedBlockingQueue.take();
		ArrayBlockingQueue arrayBlockingQueue =new ArrayBlockingQueue(4);
		arrayBlockingQueue.add("");
//		arrayBlockingQueue.take();
		SynchronousQueue synchronousQueue = new SynchronousQueue();
		synchronousQueue.add("");
//		synchronousQueue.take();
		new LinkedList<>();
		new ArrayList<>();
		new HashSet<>().add("");
		ThreadLocal local = new ThreadLocal();
		Lock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		lock.lock();
//		condition.await();
		condition.signal();


		ExecutorService executorService = Executors.newFixedThreadPool(5);
		Executors.newCachedThreadPool();
		Executors.newSingleThreadExecutor();
		executorService.execute(()->{
			System.out.println("exce");
		});
		DeadLockDemo locka = new DeadLockDemo();
		DeadLockDemo lockb = new DeadLockDemo();
		Thread threada = new Thread(
			new InnerDeadLock(locka,lockb)
		,"线程A");

		Thread threadb = new Thread(
			new InnerDeadLock(lockb,locka)
		,"线程B");
		threada.start();
		threadb.start();
	}


}
