package com.zed.demo.atomic;

/*
 * Atomic class
 */

import java.util.concurrent.atomic.AtomicReference;

import com.zed.demo.annotation.ThreadSafe;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@ThreadSafe
public class ConcurrencyAtomicStampRefrence {
	//类似，加了一个版本标签号
	//还有AtomiReferenceUpdater  更新对象的内部变量只
	//AtomicBoolean类，可以通过设置对象类用来保证只执行一次
}

