package com.chenrui.netty.rpc.provider;

import com.chenrui.netty.rpc.api.IRpcHelloService;

public class IRpcHelloServiceImpl implements IRpcHelloService {
    @Override
    public String hello(String name) {
        return "Hello " + name + "!";
    }
}
