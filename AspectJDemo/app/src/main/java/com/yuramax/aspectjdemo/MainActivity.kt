package com.yuramax.aspectjdemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.yuramax.aspectjdemo.annotations.Log
import com.yuramax.aspectjdemo.annotations.LoginFilter
import com.yuramax.aspectjdemo.core.AppContext
import com.yuramax.aspectjdemo.utils.SharedPreferencesUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testAOP()

        btnSkip.setOnClickListener {
            intentToSecondActivity()
        }

        btnSkipNoLogin.setOnClickListener {
            startActivity(Intent(this, ThridActivity::class.java))
        }

        btnSkipLoginFilter.setOnClickListener {
            startActivity(Intent(this, ExtendsLoginFilterActivity::class.java))
        }

        btnClearLoginInfo.setOnClickListener {
            SharedPreferencesUtil.remove(this, AppContext.IS_LOGIN)
            Toast.makeText(this, "清除登录信息成功！", Toast.LENGTH_SHORT).show()
        }
    }

    @LoginFilter
    @Log
    private fun intentToSecondActivity() {
        android.util.Log.d("", "intentToSecondActivity------")
        startActivity(Intent(this, SecondActivity::class.java))
    }

    private fun testAOP(){
        android.util.Log.d("", "testAOP------")
    }
}
