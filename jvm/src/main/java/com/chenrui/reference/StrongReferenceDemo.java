package com.chenrui.reference;

/**
 * 不能被垃圾回收机制回收的，出现OOM也不会回收
 */
public class StrongReferenceDemo {
	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = obj1;
		obj1 = null;
		System.gc();
		System.out.println(obj2);//obj2不会被垃圾回收
	}
}
