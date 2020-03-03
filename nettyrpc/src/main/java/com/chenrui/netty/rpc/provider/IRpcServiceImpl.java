package com.chenrui.netty.rpc.provider;

import com.chenrui.netty.rpc.api.IRpcService;

public class IRpcServiceImpl implements IRpcService {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mult(int a, int b) {
        return a * b;
    }

    public int div(int a, int b) {
        return a / b;
    }
}
