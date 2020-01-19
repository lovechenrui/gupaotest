package com.chenrui.reference;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.BlockingQueue;

/**
 * 不管内存够不够用，只要gc，就会回收
 */
public class WeakHashMapDemo {
	public static void main(String[] args) {
		LinkedHashMap linkedHashMap = new LinkedHashMap();
		linkedHashMap.put("linck","hellp");
		linkedHashMap.put("linck1","hellp1");
		TreeMap treeMap = new TreeMap();
		treeMap.put("tree","hello");
		treeMap.put("tree1","hello1");
//		myHashMap();
//		System.out.println("=================");
//		myWeakHashMap();
	}
	public static void myHashMap(){

		HashMap<Integer,String> hashMap = new HashMap<Integer,String>();
		Integer key = new Integer(1);
		hashMap.put(key,"value1");
		System.out.println(hashMap);
		key = null;
		System.out.println(hashMap);
		System.gc();
		System.out.println(hashMap);
	}
	public static void myWeakHashMap(){
		WeakHashMap<Integer,String> hashMap = new WeakHashMap<Integer,String>();
		Integer key = new Integer(1);
		hashMap.put(key,"value1");
		System.out.println(hashMap);
		key = null;
		System.out.println(hashMap);
		System.gc();
		System.out.println(hashMap);
	}
}
