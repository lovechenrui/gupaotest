package com.chenrui.reference;

import java.lang.ref.SoftReference;

public class SoftReferenceDemo {
	/**
	 * 内存足够，不回收
	 */
	public static void softRef_Memory_Enough(){
		Object o1 = new Object();
		SoftReference<Object> softReference = new SoftReference<>(o1);
		System.out.println(o1);
		System.out.println(softReference.get());
		o1 = null;
		System.gc();//内存够用的情况下，手动触发gc
		System.out.println(o1);
		System.out.println(softReference.get());

	}

	/**
	 * 内存不够，回收,
	 * 故意生产大对象，jvm配置小内存，导致OOM,查看软引用的回收情况
	 * -Xms5m -Xmx5m -XX:+PrintGCDetails
	 */
	public static void softRef_Memory_NotEnough(){
		Object o1 = new Object();
		SoftReference<Object> softReference = new SoftReference<>(o1);
		System.out.println(o1);
		System.out.println(softReference.get());
		o1 = null;
		try{
			byte[] bytes = new byte[20 * 1024 * 1024];//分配大对象，触发OOM
		}catch (Throwable throwable){
			throwable.printStackTrace();
		}finally {
			System.out.println("o1===="+o1);
			System.out.println("o1="+softReference.get());
		}
	}
	public static void main(String[] args) {
		//softRef_Memory_Enough();
		softRef_Memory_NotEnough();
	}
}
