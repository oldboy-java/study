package com.liuli.pattern;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import sun.misc.ProxyGenerator;

public class ProxyUtils {

	/***
	 * 
	 * @param clazz 被代理接口class对象
	 * @param proxyName 代理类名称
	 * @param path 文件保存路径
	 */
	public static void generateClassFile(Class<?> clazz,String proxyName,String path) {
		 //根据类信息和提供的代理类名称，生成字节码
         byte[] proxyClassFile = ProxyGenerator.generateProxyClass(proxyName,new Class[] {clazz});
         
         FileOutputStream fileOutputStream  = null;
         try {
			fileOutputStream = new FileOutputStream(path+proxyName+".class");
			fileOutputStream.write(proxyClassFile);
			fileOutputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(fileOutputStream!=null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
