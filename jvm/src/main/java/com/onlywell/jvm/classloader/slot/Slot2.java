package com.onlywell.jvm.classloader.slot;

/**
 * @author harry
 */
public class Slot2 {
	public static void main(String[] args) {
		{
			byte[] placeHolder = new byte[64 * 1024 * 1024];
		}
		/**
		 * 	仍然未被回收
		 */
		System.gc();

	}
}
