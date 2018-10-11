package com.onlywell.jvm.classloader;

import java.io.InputStream;

/**
 * @author harry
 */
public class ClassLoaderTest {
	public static void main(String[] args) throws Exception {
		ClassLoader myLoader = new ClassLoader() {
			/*
			 * (non-Javadoc)
			 * 
			 * @see java.lang.ClassLoader#loadClass(java.lang.String, boolean)
			 */
			@Override
			protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
				try {
					// class文件的全限定名
					String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";

					// 读取文件流对象
					InputStream is = getClass().getResourceAsStream(fileName);
					if (is == null) {
						return super.loadClass(name, resolve);
					}
					// 建立缓冲区
					byte[] b = new byte[is.available()];
					// 读流
					is.read(b);
					return defineClass(name, b, 0, b.length);
				} catch (Exception e) {
					throw new ClassNotFoundException(name);
				}
			}
		};
		// 实例化
		Object obj = myLoader.loadClass("com.onlywell.jvm.classloader.ClassLoaderTest").newInstance();
		// 对象的类型
		System.out.println(obj.getClass());
		System.out.println(obj instanceof com.onlywell.jvm.classloader.ClassLoaderTest);
	}
}
