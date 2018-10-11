package com.onlywell.jvm.classloader;

/**
 * @author harry
 */
public class DeadLoopCLass {
	static {
		if(true) {
			System.out.println(Thread.currentThread()+ "init DeadLoopCLass");
			while(true) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		Runnable script = new Runnable() {
			@Override
			public void run() {
				System.out.println(Thread.currentThread() + "start");
				DeadLoopCLass dlc = new DeadLoopCLass();
				System.out.println(Thread.currentThread() + "run over");
			}
		};
		Thread thread1 = new Thread(script);
		Thread thread2 = new Thread(script);
		thread1.start();
		thread2.start();
	}
}
