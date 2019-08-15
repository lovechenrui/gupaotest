package com.chenrui.concurrent.spinLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinLock {
	private AtomicReference<Thread> owner = new AtomicReference<Thread>();
	private int rentCount = 0;
	public void lock(){
		Thread thread = Thread.currentThread();
		System.out.println("线程获取锁"+thread.getName());
		if(thread == owner.get()){
			++rentCount;
			return;
		}
		while(!owner.compareAndSet(null,thread)){

		}
	}
	public void unlock(){
		Thread thread = Thread.currentThread();
		if(thread == owner.get()){
			System.out.println("线程释放锁"+thread.getName());
			if(rentCount >0){
				--rentCount;
			}else{
				owner.compareAndSet(thread,null);
			}
		}
	}

	public static void main(String[] args) {
		final SpinLock lock = new SpinLock();
		new Thread(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock.unlock();
			}
		},"t1").start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				lock.lock();
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lock.unlock();
			}
		},"t2").start();
	}
}
