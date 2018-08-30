package com.zed.demo.singleton;


import com.zed.demo.annotation.NotThreadSafe;

/*
 * 懒汉模式，，双重检查所
 * 
 * 对象创建过程
 */
@NotThreadSafe
public class SingletonExsample4 {
	private SingletonExsample4() {
		
	}
	
	/* 分配内存空间
	 * 初始化对象
	 * 制定instance执行刚分配的对象
	 * 多线程指令重排是2,3如果顺序范点到的话回到只好没有初始化完成时，instance不为null,导致另一个线程拿到未初始化完成的实力
	 **/
	
	private static SingletonExsample4 instance=null;
	public static SingletonExsample4 getInstance() {
		if(instance==null) {  //双重同步锁
			synchronized (SingletonExsample4.class) {
				instance=new SingletonExsample4();
			}		
		}
		return instance;
	}
}
