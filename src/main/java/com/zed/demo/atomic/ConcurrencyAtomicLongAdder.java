package com.zed.demo.atomic;

/*
 * Atomic class
 * 采用cas+分段所，并罚赌大，但汇总的时候可能胡出现不一致
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import com.zed.demo.annotation.ThreadSafe;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@ThreadSafe
public class ConcurrencyAtomicLongAdder {
	//请求总数
	public static int clientTotle=5000;
	
	//同时兵法执行的线程数
	public static int threadTotle=200;
	
	public static ConcurrencyAtomicLongAdder count=new ConcurrencyAtomicLongAdder();
	
    public static void main(String [] args) throws InterruptedException {
		ExecutorService executorService=Executors.newCachedThreadPool();
		final Semaphore semaphore=new Semaphore(threadTotle);
		final CountDownLatch countDownLatch=new CountDownLatch(clientTotle);
		for(int i=0;i<clientTotle;i++) {
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						semaphore.acquire();
						add();
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
		log.info("count:{}",count);
		
	}
    
    private static void add() {
    	count.add();
    	//count.incrementAndGet();
    }
}
