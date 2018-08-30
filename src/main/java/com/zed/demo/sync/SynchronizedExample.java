package com.zed.demo.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SynchronizedExample {
	public void test1(int k) {
		synchronized(this) {
			for(int i=0;i<10;i++) {
				log.info("test{}-{}",k,i);
			}
		}
	}
	
	public synchronized void test2() {
		for(int i=0;i<10;i++) {
			log.info("test1-{}",i);
		}

	}
	
	public static void main(String args[]) {
		SynchronizedExample example=new SynchronizedExample();
		SynchronizedExample example1=new SynchronizedExample();
		ExecutorService executorService=Executors.newCachedThreadPool();
		executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				example.test1(1);
			}
		});
		
/*		executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				example.test1(1);
			}
		});*/
		
		executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				example1.test1(2);
			}
		});
		
		
	}
	
}
