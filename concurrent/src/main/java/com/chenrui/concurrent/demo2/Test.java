package com.chenrui.concurrent.demo2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		String patterstr = "[a-z]+(?=;)";
		String test1="你好;中国;你好,hello;";
		Pattern pattern1 = Pattern.compile(patterstr);
		Matcher matcher = pattern1.matcher(test1);
		if(matcher.find()){
			System.out.println("JJJJ"+matcher.group(0));
		}
		System.out.println(test1.replaceAll(patterstr,"@"));

		/**
		 * (?=[a-z]+$).+$
		 */

		String test2 = "你好。world.hello";
		Pattern pattern2 = Pattern.compile("(?=[a-z]+$).+$");
		Matcher matcher1 = pattern2.matcher(test2);
		if(matcher1.find()){
			System.out.println("2222"+matcher1.group(0));
		}

		/**
		 * ( ?<=:)[0-9]+
		 */
		String test3 = "123:3444:345";
		Pattern pattern3 = Pattern.compile("(?<=:)[0-9]+");
		Matcher matcher3 = pattern3.matcher(test3);
		if(matcher3.find()){
			System.out.println("33333::"+matcher3.toString());
		}
		System.out.println(test3.replaceAll("(?<=:)[0-9]+","@"));


		String test4="0123456987";
		Pattern pattern4 = Pattern.compile("[0-9](?<=[13579])");
		Matcher matcher4 = pattern4.matcher(test4);
		if(matcher4.find()){
			System.out.println("44444:"+matcher4.group());
		}
		System.out.println(test4.replaceAll("[0-9](?<=[13579])","%"));


	}


}
