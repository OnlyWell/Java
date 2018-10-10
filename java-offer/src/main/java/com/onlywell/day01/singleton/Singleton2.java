/**
 * 
 */
package com.onlywell.day01.singleton;

/**
 * 单例模式,懒汉
 * 
 * @author harry
 */
public class Singleton2 {
	private static Singleton2 singleton;

	private Singleton2() {
	}

	public synchronized static Singleton2 getInstance() {
		if (singleton == null) {
			singleton = new Singleton2();
			return singleton;
		}
		return singleton;
	}
}
