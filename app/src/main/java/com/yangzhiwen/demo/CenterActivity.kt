package com.yangzhiwen.demo

import android.app.Activity
import android.content.*
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.os.IBinder
import android.widget.Button
import android.widget.ImageView

// todo extend AppCompatActivity has some resource error
// 有堆栈信息，主要是v7包的错
class CenterActivity : Activity() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

        findViewById<Button>(R.id.start_local).setOnClickListener {
            //            Navigator.instance.startService("user_center", "user_service", "")
            startService(Intent(this, UserCenterService::class.java))
        }

        val sc = SC()
        // bind service 之前需要先start启动
        findViewById<Button>(R.id.bind_local).setOnClickListener {
            bindService(Intent(this, UserCenterService::class.java), sc, 0)
        }

        findViewById<Button>(R.id.stop_local).setOnClickListener {
            stopService(Intent(this, UserCenterService::class.java))
        }

        findViewById<Button>(R.id.unbind_local).setOnClickListener {
            unbindService(sc)
        }

        findViewById<Button>(R.id.start_remote).setOnClickListener {
            startService(Intent(this, UserRemoteService::class.java))
        }

        val rsc = SC()
        // bind service 之前需要先start启动
        findViewById<Button>(R.id.bind_remote).setOnClickListener {
            bindService(Intent(this, UserRemoteService::class.java), rsc, 0)
        }

        findViewById<Button>(R.id.stop_remote).setOnClickListener {
            stopService(Intent(this, UserRemoteService::class.java))
        }

        findViewById<Button>(R.id.unbind_remote).setOnClickListener {
            unbindService(rsc)
        }

        findViewById<Button>(R.id.insert_provider).setOnClickListener {
            val cv = ContentValues()
            contentResolver.insert(Uri.parse("content://com.yangzhiwen.user"), cv)
        }

        findViewById<Button>(R.id.query_provider).setOnClickListener {
            contentResolver.query(Uri.parse("content://com.yangzhiwen.user"), null, null, null, null)
        }

        findViewById<Button>(R.id.delete_provider).setOnClickListener {
            contentResolver.delete(Uri.parse("content://com.yangzhiwen.user"), null, null)
        }
    }

    class SC : ServiceConnection {
        override fun onServiceDisconnected(p0: ComponentName?) {

        }

        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            println("======= onServiceConnected")
        }
    }
}
