package com.zed.demo.singleton;

import com.zed.demo.annotation.NotRecommend;
import com.zed.demo.annotation.ThreadSafe;

/*
 * 懒汉模式，直接枷锁，县城含权，但是性能不够好
 */
@ThreadSafe
@NotRecommend
public class SingletonExsample3 {
	private SingletonExsample3() {
		
	}
	
	private static SingletonExsample3 instance=null;
	public static synchronized SingletonExsample3 getInstance() {
		if(instance==null) {  //可能导致创建两个对象
			instance=new SingletonExsample3();
		}
		return instance;
	}
}
