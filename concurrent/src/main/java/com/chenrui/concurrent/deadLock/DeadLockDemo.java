package com.chenrui.concurrent.deadLock;

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
					synchronized (lockb) {
						System.out.println(Thread.currentThread().getName() + "等待锁");
					}
				}
			}
		}

	}
	public static void main(String[] args) {
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
