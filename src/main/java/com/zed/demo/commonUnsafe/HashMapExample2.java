package com.zed.demo.commonUnsafe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

import com.zed.demo.annotation.NotThreadSafe;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@NotThreadSafe
public class HashMapExample2 {
	//请求总数
	public static int clientTotle=5000;
	
	//同时兵法执行的线程数
	public static int threadTotle=200;
	
	public static Map<Integer, Integer> map=new HashMap<>();
    public static void main(String [] args) throws InterruptedException {
		ExecutorService executorService=Executors.newCachedThreadPool();
		final Semaphore semaphore=new Semaphore(threadTotle);
		final CountDownLatch countDownLatch=new CountDownLatch(clientTotle);
		for(int i=0;i<clientTotle;i++) {
			final int count=i;
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						semaphore.acquire();
						add(count);
						semaphore.release();
					}catch (Exception e) {
						// TODO: handle exception
						System.out.println("exception:"+e);
						log.error("exception",e);
					}
					countDownLatch.countDown();
				}
			});
		}
		countDownLatch.await();
		log.info("count:{}",map.size());
		
	}
    
    private static void add(int i) {
    	map.put(i, i);
    }
}
