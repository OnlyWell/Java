package com.onlywell.jvm.classloader.slot;

/**
 * @author harry
 */
public class Slot3 {
	public static void main(String[] args) {
		{
			byte[] placeHolder = new byte[1024 * 1024 * 640];
		}
		/**
		 * 发生了垃圾回收
		 */
		int a = 0;
		System.gc();
	}
}
