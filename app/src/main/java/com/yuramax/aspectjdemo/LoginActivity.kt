package com.yuramax.aspectjdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.yuramax.aspectjdemo.core.AppContext
import com.yuramax.aspectjdemo.utils.SharedPreferencesUtil
import kotlinx.android.synthetic.main.activity_login.*

/**
 * 作者：weijun
 * 日期：2019/4/9
 * 作用：
 */
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener{
            SharedPreferencesUtil.put(this,AppContext.IS_LOGIN, true)
            Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show()
            finish()
        }

        btnQuit.setOnClickListener {
            SharedPreferencesUtil.remove(this,AppContext.IS_LOGIN)
        }
    }
}