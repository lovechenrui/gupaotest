package com.chenrui.partten.proxy.jdk.custom;

import java.lang.reflect.Method;

public class CustomProxy implements GPInvocationHandler {
	private Object target;
	public Object getInstance(Object target){
		this.target = target;
//		return GPProxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
		return GPProxy.newProxyInstance(new GPClassLoad(),target.getClass().getInterfaces(),this);
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("自定义代理调用前》》》》》");
		method.invoke(target,args);
		System.out.println("自定义代理调用后》》》》》");
		return null;
	}
}
