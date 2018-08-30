package com.zed.demo.singleton;

import com.zed.demo.annotation.NotThreadSafe;

/*
 * 懒汉模式
 */
@NotThreadSafe
public class SingletonExsample1 {
	private SingletonExsample1() {
		
	}
	
	private static SingletonExsample1 instance=null;
	public static SingletonExsample1 getInstance() {
		if(instance==null) {  //可能导致创建两个对象
			instance=new SingletonExsample1();
		}
		return instance;
	}
}
