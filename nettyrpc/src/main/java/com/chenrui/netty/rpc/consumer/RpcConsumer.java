package com.chenrui.netty.rpc.consumer;

import com.chenrui.netty.rpc.api.IRpcHelloService;

public class RpcConsumer {
    public static void main(String[] args) {
        IRpcHelloService rpcHelloService = RpcProxy.create(IRpcHelloService.class);
        System.out.println(rpcHelloService.hello("Tom老师"));
    }
}
