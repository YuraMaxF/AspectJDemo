package com.yuramax.aspectjdemo.aop.aspect;

import android.content.Context;

import com.yuramax.aspectjdemo.annotations.LoginFilter;
import com.yuramax.aspectjdemo.aop.ILogin;
import com.yuramax.aspectjdemo.aop.LoginAssistant;
import com.yuramax.aspectjdemo.execption.AnnotationException;
import com.yuramax.aspectjdemo.execption.NoInitException;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * 作者：weijun
 * 日期：2019/4/9
 * 作用：
 */

@Aspect
public class LoginFilterAspect {
    private static final String TAG = "LoginFilterAspect";
    // && @annotation(loginFilter)
    @Pointcut("execution(@com.yuramax.aspectjdemo.annotations.LoginFilter * *(..))")
    public void loginFilter() {

    }

    @Around("loginFilter()")
    public void aroundLoginPoint(ProceedingJoinPoint joinPoint) throws Throwable {

        ILogin iLogin = LoginAssistant.getInstance().getiLogin();
        if (iLogin == null) {
            throw new NoInitException("LoginSDK 没有初始化！");
        }

        Signature signature = joinPoint.getSignature();
        if (!(signature instanceof MethodSignature)) {
            throw new AnnotationException("LoginFilter 注解只能用于方法上");
        }
        MethodSignature methodSignature = (MethodSignature) signature;
        LoginFilter loginFilter = methodSignature.getMethod().getAnnotation(LoginFilter.class);
        if (loginFilter == null) {
            return;
        }

        Context param = LoginAssistant.getInstance().getApplicationContext();

        if (iLogin.isLogin(param)) {
            joinPoint.proceed();
        } else {
            iLogin.login(param, loginFilter.userDefine());
        }

    }

}

