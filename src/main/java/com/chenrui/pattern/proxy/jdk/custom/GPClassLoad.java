package com.chenrui.pattern.proxy.jdk.custom;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class GPClassLoad extends ClassLoader{
	private File classPathFile;
	public GPClassLoad(){
		String classPath = GPClassLoad.class.getResource("").getPath();
		this.classPathFile  = new File(classPath);
	}
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException{
		String className = GPClassLoad.class.getPackage().getName()+"."+name;
		if(classPathFile != null){
			File classFile = new File(classPathFile,name.replaceAll("\\.","/")+".class");
			if(classFile.exists()){
				FileInputStream in = null;
				ByteArrayOutputStream out = null;
				try{
					in = new FileInputStream(classFile);
					out = new ByteArrayOutputStream();
					byte[] buff = new byte[1024];
					int len;
					while ((len = in.read(buff)) != -1){
						out.write(buff,0,len);
					}
					return defineClass(className,out.toByteArray(),0,out.size());
				}catch (Exception e){
					e.printStackTrace();
				}finally {
					if(null != in){
						try{
							in.close();
						}catch (Exception e){
							e.printStackTrace();
						}
					}
					if(null != out){
						try{
							out.close();
						}catch (Exception e){
							e.printStackTrace();
						}
					}
				}
			}
		}
		return null;
	}
}
