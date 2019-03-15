package com.chenrui.pattern.delegate.leader;

public class TargetB implements ITarget {
    public void doing(String command) {
        System.out.println("我是B ,我负责做"+command);
    }
}
