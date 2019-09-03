package com.chenrui.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池导致内存溢出
 * vm Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * jdk1.6 常量池在方法区（永久代）所以通过设置永久代的大小，可以间接控制常量池的大小 。
 *
 */
public class RuntimeConstantPoolOOM {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		int i= 0;
//		while(true){
//			list.add(String.valueOf(i++).intern());
//		}
		test();
	}
	public static void test(){
		String str0="123"+"12345";
		String a = str0+"000000";
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
	}
}
