package com.chenrui.pattern.delegate.leader;

public class TargetA implements ITarget {
    public void doing(String command) {
        System.out.println("我是A ,我负责做"+command);
    }
}
