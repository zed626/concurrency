package com.zed.demo.aqs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FutureExample {
	static class MyCallable implements Callable<String>{

		@Override
		public String call() throws Exception {
			// TODO Auto-generated method stub
			log.info("do something in callable");
			Thread.sleep(5000);
			return "done";
		}
		
	}
	
	public static void main(String args[]) throws InterruptedException, ExecutionException {
		ExecutorService executorService=Executors.newCachedThreadPool();
		Future<String> future=executorService.submit(new MyCallable());
		log.info("do someting in main");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String result=future.get();
		log.info("result:{}",result);
	}
}
