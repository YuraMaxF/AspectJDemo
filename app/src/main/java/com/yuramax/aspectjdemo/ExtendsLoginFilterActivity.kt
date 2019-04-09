package com.yuramax.aspectjdemo

import android.os.Bundle

/**
 * 作者：weijun
 * 日期：2019/4/9
 * 作用：
 */
class ExtendsLoginFilterActivity : LoginFilterActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extends_login_filter)
    }

}