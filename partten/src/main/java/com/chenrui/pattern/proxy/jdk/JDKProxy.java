package com.chenrui.pattern.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy implements InvocationHandler {

	private Object target;

	public Object getInstance(Object target){
		this.target = target;
		Class<?> clazz = target.getClass();
		return Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("调用前的日志》》》");
		Object res = method.invoke(this.target,args);
		System.out.println("调用后的日志》》》");
		return res;
	}
}
