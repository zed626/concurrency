package com.zed.demo.immutable;

import java.util.HashMap;
import java.util.Map;

import com.zed.demo.annotation.NotThreadSafe;


@NotThreadSafe
public class ImmutableExample {
	private final static Integer A=0;
	private final static String B_STRING="2";
	private final static Map<Integer, Integer> MAP=new HashMap<>();
	
	static {
		MAP.put(1, 5);
		//MAP=new HashMap<>();
	}
	
	public static void main(String [] args) {
		MAP.put(7, 5);
		//A=41;
		//B_STRING="445";
		
	}
	
	public void test(final int a) {
		//a=3;
	}
}
