package com.yuramax.aspectjdemo.aop.aspect;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 作者：weijun
 * 日期：2019/4/9
 * 作用：
 */

@Aspect
public class LogFilter {

    private final static String tag = "测试---";

    @Pointcut("execution(@com.yuramax.aspectjdemo.annotations.Log * *(..))")
    public void logFilter() {

    }

    @Before("logFilter()")
    public void onLogMethodBefore(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        Log.d(tag, "onLogMethodBefore: " + key);
    }

    @Before("call(* com.yuramax.aspectjdemo.MainActivity.testAOP(..))")
    public void onActivityMethodBefore(JoinPoint joinPoint) throws Throwable {
        String key = joinPoint.getSignature().toString();
        Log.d(tag, "onActivityMethodBefore: " + key);
    }

}
