package com.yuramax.aspectjdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.yuramax.aspectjdemo.aop.LoginAssistant

/**
 * 作者：weijun
 * 日期：2019/4/9
 * 作用：
 */
open class LoginFilterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!LoginAssistant.getInstance().getiLogin().isLogin(applicationContext)) {
            //这里想做什么就做什么，在这里让页面结束，并给用户提示
            Toast.makeText(this, "没有登录！", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}