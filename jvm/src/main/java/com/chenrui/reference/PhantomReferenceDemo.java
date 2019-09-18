package com.chenrui.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * 虚引用：形同虚设，主要用来监控对象的回收状态，get方法总是返回null,需要和ReferenceQueue配合使用
 */
public class PhantomReferenceDemo {
	public static void main(String[] args) throws InterruptedException {
		Object obj = new Object();
		ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
		PhantomReference<Object> phantomReference = new PhantomReference<>(obj,referenceQueue);
		System.out.println(obj);
		System.out.println(phantomReference.get());
		System.out.println(referenceQueue.poll());
		System.out.println("======================");
		obj = null;
		System.gc();
		Thread.sleep(500);
		System.out.println(obj);
		System.out.println(phantomReference.get());
		System.out.println(referenceQueue.poll());

	}
}
