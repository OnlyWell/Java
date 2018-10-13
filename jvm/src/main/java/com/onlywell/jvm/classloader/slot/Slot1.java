/**
 * 
 */
package com.onlywell.jvm.classloader.slot;

/**
 * @author harry
 */
public class Slot1 {
	public static void main(String[] args) {
		byte[] placeholder = new byte[64 * 1024 * 1024];
		/*
		 *  	没有回收掉内存,因为System.gc()还在placeholder的
		 *   	作用域范围内
		 */
		System.gc();
	}
}
