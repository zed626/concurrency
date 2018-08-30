package com.zed.demo.singleton;


import com.zed.demo.annotation.ThreadSafe;

/*
 * 懒汉模式，，双重检查所
 * 
 * 对象创建过程
 */
@ThreadSafe
public class SingletonExsample5 {
	private SingletonExsample5() {
		
	}
	
	/* 分配内存空间
	 * 初始化对象
	 * 制定instance执行刚分配的对象
	 * 多线程指令重排是2,3如果顺序范点到的话回到只好没有初始化完成时，instance不为null,导致另一个线程拿到未初始化完成的实力
	 * 
	 * 通过volatile限制指令重排
	 **/
	
	private static volatile SingletonExsample5 instance=null;
	public static SingletonExsample5 getInstance() {
		if(instance==null) {  //双重同步锁
			synchronized (SingletonExsample5.class) {
				instance=new SingletonExsample5();
			}		
		}
		return instance;
	}
}
