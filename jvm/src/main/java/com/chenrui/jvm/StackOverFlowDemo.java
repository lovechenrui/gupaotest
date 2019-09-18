package com.chenrui.jvm;

public class StackOverFlowDemo {
	public static void main(String[] args) {
		f();
	}
	private static void f(){
		f();
	}
}
