package com.zed.demo.atomic;

/*
 * Atomic class
 */

import java.util.concurrent.atomic.AtomicReference;

import com.zed.demo.annotation.ThreadSafe;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@ThreadSafe
public class ConcurrencyAtomicRefrence {
	private static AtomicReference<Integer> count=new AtomicReference<Integer>(0);
	
    public static void main(String [] args) throws InterruptedException {
    	count.compareAndSet(0, 2);
    	count.compareAndSet(1, 3);
    	count.compareAndSet(2, 5);
    	count.compareAndSet(5, 8);
    	count.compareAndSet(3, 4);
		log.info("count:{}",count);
		
	}
 
}
