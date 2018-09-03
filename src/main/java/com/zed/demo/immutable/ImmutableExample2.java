package com.zed.demo.immutable;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.zed.demo.annotation.ThreadSafe;


@ThreadSafe
public class ImmutableExample2 {

	private static Map<Integer, Integer> MAP=new HashMap<>();
	
	static {
		MAP.put(1, 5);
		MAP=Collections.unmodifiableMap(MAP);
		//MAP=new HashMap<>();
	}
	
	public static void main(String [] args) {
		MAP.put(7, 5);
		//A=41;
		//B_STRING="445";
		
	}
	

}
