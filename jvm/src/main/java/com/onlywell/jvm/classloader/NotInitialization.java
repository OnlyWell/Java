package com.onlywell.jvm.classloader;

/**
 * @author harry
 * 
 * 		通过子类引用父类的静态字段,不会导致子类初始化
 */

public class NotInitialization {
	
	public static void main(String[] args) {
		System.out.println(SubClass.value);
	}
}


class SubClass extends SuperClass{
	static {
		System.out.println("SubClass init");
	}
}

class SuperClass{
	static {
		System.out.println("SuperClass init!");
	}
	public static int value = 123;
}