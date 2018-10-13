package com.onlywell.jvm.classloader.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author harry
 */
public class DynamicProxyTest {

	interface IHello {
		void sayHello();
	}

	static class Hello implements IHello {

		/*
		 * (non-Javadoc)
		 * 
		 * @see com.onlywell.jvm.classloader.proxy.DynamicProxyTest.IHello#sayHello()
		 */
		@Override
		public void sayHello() {
			System.out.println("hello world!");
		}

	}

	static class DynamicProxy implements InvocationHandler {

		Object originalObj;

		Object bind(Object originalObj) {
			this.originalObj = originalObj;

			return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(),
					originalObj.getClass().getInterfaces(), this);
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
		 * java.lang.reflect.Method, java.lang.Object[])
		 */
		@Override
		public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

			System.out.println("welcome");
			return method.invoke(originalObj, args);
		}
	}

	public static void main(String[] args) {
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		IHello hello = (IHello) new DynamicProxy().bind(new Hello());
		hello.sayHello();
	}
}
