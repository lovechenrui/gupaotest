package com.chenrui.reference;

import java.lang.ref.WeakReference;

/**
 * 不管内存够不够用，只要gc，就会回收
 */
public class WeakReferenceDemo {
	public static void main(String[] args) {
		Object obj1 = new Object();
		WeakReference<Object> weakReference = new WeakReference<>(obj1);
		System.out.println(weakReference.get());
		obj1 = null;
		System.gc();
		System.out.println(weakReference.get());
	}
}
