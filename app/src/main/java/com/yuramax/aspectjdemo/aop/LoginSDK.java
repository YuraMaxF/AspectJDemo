package com.yuramax.aspectjdemo.aop;

import android.content.Context;

/**
 * 作者：weijun
 * 日期：2019/4/9
 * 作用：
 */

public class LoginSDK {
    private static LoginSDK instance;
    private Context applicationContext;

    private LoginSDK() {}

    public static LoginSDK getInstance() {
        if (instance == null) {
            synchronized (LoginSDK.class) {
                if (instance == null) {
                    instance = new LoginSDK();
                }
            }
        }
        return instance;
    }

    public void init(Context context, ILogin iLogin) {
        applicationContext = context.getApplicationContext();
        LoginAssistant.getInstance().setApplicationContext(context);
        LoginAssistant.getInstance().setiLogin(iLogin);
    }

    /**
     * 单点登录，验证token失效的统一接入入口
     */
    public void serverTokenInvalidation(int userDefine) {
        LoginAssistant.getInstance().serverTokenInvalidation(userDefine);
    }
}