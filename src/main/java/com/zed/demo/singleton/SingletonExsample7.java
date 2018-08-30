package com.zed.demo.singleton;

import com.zed.demo.annotation.Recommend;
import com.zed.demo.annotation.ThreadSafe;

/*
	枚举模式，最安全
 */
@ThreadSafe
@Recommend
public class SingletonExsample7 {
	private SingletonExsample7() {
		
	}
	
	public static SingletonExsample7 getInstance() {
		return Singleton.INSTANCE.getInstance();
	}
	
	private enum Singleton{
		INSTANCE;
		private SingletonExsample7 singleton;
		
		//JVM保证这个方法绝对只执行一次
		Singleton(){
			singleton=new SingletonExsample7();
		}
		
		public SingletonExsample7 getInstance() {
			return singleton;
		}
		
	}
}
