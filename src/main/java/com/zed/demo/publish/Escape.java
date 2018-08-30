package com.zed.demo.publish;

import lombok.extern.slf4j.Slf4j;

import com.zed.demo.annotation.NotRecommend;
import com.zed.demo.annotation.NotThreadSafe;

/*
 * 在构造完成之前，状态还没有初始化
 */

@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape () {
        new InnerClass();
    }

    private class InnerClass {

        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
