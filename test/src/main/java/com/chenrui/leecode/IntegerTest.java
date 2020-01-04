package com.chenrui.leecode;

import java.lang.reflect.Field;

public class IntegerTest {
    public static void main(String[] args) {
        Integer a=1;
        Integer b=2;
       // swap(a,b);
        swap1(a,b);
//        int temp = a;
//        a=b;
//        b=temp;
        System.out.println(a+","+b);
    }

    //基本类型的封装类型，传递的是变量的副本
    static void swap(Integer a,Integer b){
        Integer temp = a;
        a=b;
        b=temp;
    }

    static void swap1(Integer a,Integer b){
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            int temp = a.intValue();//替换成Integer temp = new Integer(a.intValue())或者下面使用field.setInt()避免装箱操作
            field.set(a,b.intValue());
            field.set(b,temp);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}