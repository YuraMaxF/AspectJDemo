package com.yuramax.aspectjdemo.core;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.yuramax.aspectjdemo.LoginActivity;
import com.yuramax.aspectjdemo.aop.ILogin;
import com.yuramax.aspectjdemo.aop.LoginSDK;
import com.yuramax.aspectjdemo.utils.SharedPreferencesUtil;

/**
 * 作者：weijun
 * 日期：2019/4/9
 * 作用：
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LoginSDK.getInstance().init(this, iLogin);
    }

    ILogin iLogin = new ILogin() {
        @Override
        public void login(Context applicationContext, int userDefine) {
            switch (userDefine) {
                case 0:
                    startActivity(new Intent(applicationContext, LoginActivity.class));
                    break;
                case 1:
                    Toast.makeText(applicationContext, "您还没有登录，请登陆后执行", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    Toast.makeText(applicationContext, "执行失败，因为您还没有登录！", Toast.LENGTH_SHORT).show();
                    break;
            }
        }

        @Override
        public boolean isLogin(Context applicationContext) {
            return (boolean) SharedPreferencesUtil.get(applicationContext,AppContext.IS_LOGIN,false);
        }

        @Override
        public void clearLoginStatus(Context applicationContext) {
            SharedPreferencesUtil.put(applicationContext,AppContext.IS_LOGIN, false);
        }
    };
}

