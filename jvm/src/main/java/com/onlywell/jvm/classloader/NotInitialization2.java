package com.onlywell.jvm.classloader;

/**
 * @author harry
 * 	
 * 	非主动使用类字段,并没有初始化类
 * 	
 * 	书名在编译阶段将helloworld常量存储到了NotInitialization2类的常量池中,
 * 	对常量ConstClass.HELLOWORLD的引用被转换成了NotInitialization2类对
 *       自身常量池的引用.   说明NotInitialization2的Class文件中没有ConstClass
 *       类的符号引用.
 */
public class NotInitialization2 {
	public static void main(String[] args) {
		System.out.println(ConstClass.HELLOWORLD);
	}
}

class ConstClass{
	static {
		System.out.println("ConstClass init!");
	}
	public static final String HELLOWORLD = "hello world";
}



