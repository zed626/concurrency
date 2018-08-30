package com.zed.demo.singleton;

import com.zed.demo.annotation.ThreadSafe;

/*
 * 饿汉模式，但历史里在类装载时被创建
 * 可能导致资源浪费
 */
@ThreadSafe
public class SingletonExsample2 {
	private SingletonExsample2() {
		
	}
	
	private static SingletonExsample2 instance=new SingletonExsample2();
	public static SingletonExsample2 getInstance() {
		return instance;
	}
}
