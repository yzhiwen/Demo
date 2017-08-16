package com.yangzhiwen.demo

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import com.yangzhiwen.armour.compass.Navigator
import com.yangzhiwen.armour.ext.compass.*

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        println(Navigator::class.java.classLoader)
//
//        val newN = Navigator()
//        newN.context = this
//        newN.registerActivityComponent(false, "user_center", "setting", "com.yangzhiwen.demo.MainActivity")
//        newN.registerActivityComponent(false, "user_center", "center", "com.yangzhiwen.demo.CenterActivity")
//        newN.registerServiceComponent(false, "user_center", "user_service", "com.yangzhiwen.demo.UserCenterService")
//
//        val actions = arrayOf("user_center_msg", "user_center_setting_msg")
//        newN.registerReceiverComponent(false, "user_center", "user_center_receiver", "com.yangzhiwen.demo.UserCenterReceiver", *actions)

//        newN.registerActivityComponentHandler()
//        newN.registerServiceComponentHandler()

        findViewById<Button>(R.id.center).setOnClickListener {
            Navigator.instance.startActivity("user_center", "center", "arg")
        }
    }
}
