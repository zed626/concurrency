package com.zed.demo.singleton;

import com.zed.demo.annotation.ThreadSafe;

/*
 * 饿汉模式，但历史里在类装载时被创建
 * 可能导致资源浪费
 */
@ThreadSafe
public class SingletonExsample6 {
	private SingletonExsample6() {
		
	}
	
	private static SingletonExsample6 instance=null;  //和静态代码块的顺序不能变
	static {
		instance=new SingletonExsample6();
	}
	public static SingletonExsample6 getInstance() {
		return instance;
	}
}
