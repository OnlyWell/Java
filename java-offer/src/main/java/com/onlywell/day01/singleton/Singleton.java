package com.onlywell.day01.singleton;

/**
 * 单例模式, 恶汉模式
 * 
 * @author harry
 */
public class Singleton {
	private static final Singleton singleton = new Singleton();

	private Singleton() {
	}

	public static Singleton getInstance() {
		return singleton;
	}
}
