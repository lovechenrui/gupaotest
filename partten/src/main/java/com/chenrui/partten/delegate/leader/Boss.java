package com.chenrui.partten.delegate.leader;

/**
 * 代理模式 注重的是过程，委派模式注重的是结果
 * 委派模式持有被委派者的引用
 * 委派的核心：分发，调度，派遣
 */
public class Boss {

    public static void main(String[] args) {
        Leader leader = new Leader();
        leader.doing("登陆");
    }
}
