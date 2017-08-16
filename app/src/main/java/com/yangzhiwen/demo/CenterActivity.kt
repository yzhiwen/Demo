package com.yangzhiwen.demo

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.yangzhiwen.armour.compass.Navigator
import com.yangzhiwen.armour.ext.compass.bindService
import com.yangzhiwen.armour.ext.compass.startService

// todo extend AppCompatActivity has some resource error
// 有堆栈信息，主要是v7包的错
class CenterActivity : Activity() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Bus.instance.register(this)

//        codeView()
// todo 如果没有处理资源的话，通过欺上瞒下启动该Activity会失败，不会报错，而是跳转到Proxy Activity
        xmlView()
    }

    fun onEvent(d: Drawable) {
        findViewById<ImageView>(R.id.iv).setImageDrawable(d)
    }

    private fun xmlView() {
        setContentView(R.layout.activity_setting)
        findViewById<Button>(R.id.send).setOnClickListener {
            sendBroadcast(Intent("user_center_setting_msg"))
        }

        findViewById<Button>(R.id.start).setOnClickListener {
            Navigator.instance.startService("user_center", "user_service", "user_service arg xixi")
        }

        // bind service 之前需要先start启动
        findViewById<Button>(R.id.bind).setOnClickListener {
            Navigator.instance.bindService("user_center", "user_service", SC(), "user_service arg xixi")
        }
    }

    class SC : ServiceConnection {
        override fun onServiceDisconnected(p0: ComponentName?) {

        }

        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            println("== === = =onServiceConnected")
        }
    }
}
