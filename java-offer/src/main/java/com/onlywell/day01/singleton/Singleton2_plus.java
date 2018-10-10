/**
 * 
 */
package com.onlywell.day01.singleton;

/**
 * 单例模式
 * @author harry
 */
public class Singleton2_plus {
	private static Singleton2_plus plus;
	private Singleton2_plus() {}
	
	//当用不同的ClassLoader加载时仍然会有多个实例
	public synchronized Singleton2_plus getInstance() {
		synchronized (Singleton2_plus.class) {
			if(null == plus) {
				plus = new Singleton2_plus();
				return plus;
			}
			return plus;
		}
	}
}
