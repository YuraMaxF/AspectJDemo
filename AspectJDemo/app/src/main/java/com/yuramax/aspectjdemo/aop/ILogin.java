package com.yuramax.aspectjdemo.aop;

import android.content.Context;

/**
 * 作者：weijun
 * 日期：2019/4/9
 * 作用：
 */

public interface ILogin {

    /**
     * 登录事件接收
     * @param applicationContext
     * @param userDefine
     */
    void login(Context applicationContext, int userDefine);

    /**
     * 判断是否登录
     * @param applicationContext
     * @return
     */
    boolean isLogin(Context applicationContext);

    /**
     * 清楚登录状态
     * @return
     */
    void clearLoginStatus(Context applicationContext);

}