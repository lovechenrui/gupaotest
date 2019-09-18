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
		/**
		 * 字符串的拼接会优化成"12312345";
		 * javap -c test.class 查看字节码文件可验证
		 */
		String str0="123"+"12345";

		/**
		 * 字符串的拼接会优化成StringBuilder.append()
		 * javap -c test.class 查看字节码文件可验证
		 */
		String a = str0+"000000";

		/**
		 * intern（）如果常量池有字符串，则返回，没有添加到常量池后，返回字符串的引用
		 * jdk6 首次遇到字符串，会复制字符串到常量池 ，常量池中的引用和java堆中的引用不是同一个对象
		 * jdk7以后，不在复制，只是在常量池中记录首次出现字符串的引用
		 *
		 */
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1);
		String str2 = new StringBuilder("ja").append("va").toString();
		System.out.println(str2.intern() == str2);
	}
}
