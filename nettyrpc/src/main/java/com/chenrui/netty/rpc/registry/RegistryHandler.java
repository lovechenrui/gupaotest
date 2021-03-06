package com.chenrui.netty.rpc.registry;

import com.chenrui.netty.rpc.protocol.InvokerProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 扫描指定包路径下的服务接口，注册到map里
 */
public class RegistryHandler extends ChannelInboundHandlerAdapter {

    //保存所有的服务类
    private List<String> classNames = new ArrayList<String>();
    //保存所有可用的服务
    private ConcurrentHashMap<String, Object> registryMap = new ConcurrentHashMap<String, Object>();

    public RegistryHandler(){
        scannerClass("com.chenrui.netty.rpc.provider");
        doRegister();
    }

    private void scannerClass(String packageName) {
        URL url = this.getClass().getClassLoader().getResource(packageName.replaceAll("\\.","/"));
        File dir = new File(url.getFile());
        for(File file:dir.listFiles()){
            if(file.isDirectory()){
                scannerClass(packageName+"."+file.getName());
            }else{
                classNames.add(packageName+"."+file.getName().replace(".class","").trim());
            }
        }
    }
    private void doRegister() {
        if(classNames.size() ==  0){return;}
        for(String className:classNames){
            try {
                Class<?> clazz = Class.forName(className);
                Class<?> i = clazz.getInterfaces()[0];
                registryMap.put(i.getName(),clazz.newInstance());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception{
        Object result = new Object();
        InvokerProtocol request = (InvokerProtocol) msg;
        if(registryMap.containsKey(request.getClassName())){
            Object clazz = registryMap.get(request.getClassName());
            Method method = clazz.getClass().getMethod(request.getMethodName(),request.getParames());
            result = method.invoke(clazz,request.getValues());
        }
        ctx.write(result);
        ctx.flush();
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
