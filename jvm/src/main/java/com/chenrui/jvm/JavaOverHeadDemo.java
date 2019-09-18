package com.chenrui.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * GC过于频繁，并且每次GC后效果不明显
 * -Xms5m -Xmx5m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
 */
public class JavaOverHeadDemo {
	public static void main(String[] args) {
		int i = 0;
		List<String> list = new ArrayList<String>();
		try{
			while (true){
				list.add(String.valueOf(i++).intern());//不断的往list里添加对象，沾满队内存出发GC
			}
		}catch (Exception e){
			System.out.println("*****************"+i);
			e.printStackTrace();
		}
	}
}
