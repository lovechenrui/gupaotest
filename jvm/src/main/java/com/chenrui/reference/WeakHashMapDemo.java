package com.chenrui.reference;

import java.util.HashMap;
import java.util.WeakHashMap;

/**
 * 不管内存够不够用，只要gc，就会回收
 */
public class WeakHashMapDemo {
	public static void main(String[] args) {
		myHashMap();
		System.out.println("=================");
		myWeakHashMap();
	}
	public static void myHashMap(){
		HashMap<Integer,String> hashMap = new HashMap<>();
		Integer key = new Integer(1);
		hashMap.put(key,"value1");
		System.out.println(hashMap);
		key = null;
		System.out.println(hashMap);
		System.gc();
		System.out.println(hashMap);
	}
	public static void myWeakHashMap(){
		WeakHashMap<Integer,String> hashMap = new WeakHashMap<>();
		Integer key = new Integer(1);
		hashMap.put(key,"value1");
		System.out.println(hashMap);
		key = null;
		System.out.println(hashMap);
		System.gc();
		System.out.println(hashMap);
	}
}
