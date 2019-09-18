package com.chenrui.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/**
 * 引用队列：在对象回收前会进入队列
 */
public class ReferenceQueueDemo {
	public static void main(String[] args) throws InterruptedException {
		Object obj = new Object();
		ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
		WeakReference<Object> weakReference = new WeakReference<>(obj,referenceQueue);
		System.out.println(obj);
		System.out.println(weakReference.get());//回收前，弱引用对象
		System.out.println(referenceQueue.poll());//回收前引用队列里的对象
		obj = null;
		System.gc();
		Thread.sleep(500);
		System.out.println("====================================");
		System.out.println(obj);
		System.out.println(weakReference.get());//回收后，弱引用对象
		System.out.println(referenceQueue.poll());//回收后引用队列里的对象
	}
}
