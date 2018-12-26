package com.chenrui.pattern.proxy.jdk.custom;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class GPProxy {
	private static final String ln = "\r\n";
	public static Object newProxyInstance(ClassLoader classLoad,Class<?>[] interfaces,GPInvocationHandler h){
		try{
			/**
			 * 1、动态生成源文件
			 */
			String srcStr = generateJava(interfaces);
			/**
			 * 2、源文件写到磁盘
			 */
			String filePath = GPProxy.class.getResource("").getPath();
			System.out.println(filePath);
			File f = new File(filePath+"$Proxy0.java");
			FileWriter fileWriter = new FileWriter(f);
			fileWriter.write(srcStr);
			fileWriter.flush();
			fileWriter.close();
			/**
			 * 3、编译成字节码文件
			 */
			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
			Iterable iterable = manager.getJavaFileObjects(f);
			JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,null,null,iterable);
			task.call();
			manager.close();
			/**
			 * 4、加载到内存
			 */
			String name = GPProxy.class.getPackage().getName() + ".$Proxy0";
			Class proxyClass = classLoad.loadClass(name);
			Constructor constructor = proxyClass.getConstructor(GPInvocationHandler.class);
//			f.delete();
			/**
			 * 5、返回代理对象
			 */
			return constructor.newInstance(h);
		}catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	private static String generateJava(Class<?>[] interfaces) {
		StringBuffer sb = new StringBuffer();
		sb.append("package com.chenrui.pattern.proxy.jdk.custom;"+ln);
		sb.append("import com.chenrui.pattern.proxy.jdk.custom.Order;"+ln);
		sb.append("import java.lang.reflect.Method;"+ln);
		sb.append("public class $Proxy0 implements "+interfaces[0].getName()+"{"+ln);
		sb.append("GPInvocationHandler h;"+ln);
		sb.append("public $Proxy0(GPInvocationHandler h) {"+ln);
		sb.append("this.h=h;"+ln);
		sb.append("}"+ln);
		for(Method m:interfaces[0].getMethods()){
			sb.append("public "+m.getReturnType().getName()+" "+m.getName()+"(){"+ln);
			sb.append("try{"+ln);
			sb.append("Method m =" +interfaces[0].getName()+".class.getMethod(\""+m.getName()+"\",new Class[]{});"+ln);
			sb.append(" this.h.invoke(this,m,null);"+ln);
			sb.append("}catch(Throwable e){"+ln);
			sb.append("e.printStackTrace();"+ln);
			sb.append("}"+ln);
			sb.append("return 0;"+ln);
			sb.append("}"+ln);
		}
		sb.append("}"+ln);
		return sb.toString();
	}
}
