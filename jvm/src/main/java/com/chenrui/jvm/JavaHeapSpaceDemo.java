package com.chenrui.jvm;

/**\
 * -Xms5m -Xmx5m -XX:PrintGCDetails -XX
 */
public class JavaHeapSpaceDemo {
	public static void main(String[] args) {
		byte b[] = new byte[10*1024*1024];
	}
}
