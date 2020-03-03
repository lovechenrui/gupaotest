package com.chenrui.partten.singleton;

public class EnumSingleTonTest {
    public static void main(String[] args) {
        EnumSingleTon enumSingleTon = EnumSingleTon.getInstance();
        enumSingleTon.setData(new Object());
        System.out.println(enumSingleTon);
    }
}
