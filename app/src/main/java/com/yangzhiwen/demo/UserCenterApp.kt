package com.yangzhiwen.demo

import android.app.Application
import com.yangzhiwen.armour.compass.Navigator
import com.yangzhiwen.armour.ext.compass.*

/**
 * Created by yangzhiwen on 17/8/16.
 */
class UserCenterApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Navigator.instance.context = this
        Navigator.instance.registerActivityComponent(false, "user_center", "setting", "com.yangzhiwen.demo.MainActivity")
        Navigator.instance.registerActivityComponent(false, "user_center", "center", "com.yangzhiwen.demo.CenterActivity")
        Navigator.instance.registerServiceComponent(false, "user_center", "user_service", "com.yangzhiwen.demo.UserCenterService")

        val actions = arrayOf("user_center_msg", "user_center_setting_msg")
        Navigator.instance.registerReceiverComponent(false, "user_center", "user_center_receiver", "com.yangzhiwen.demo.UserCenterReceiver", *actions)

        Navigator.instance.registerActivityComponentHandler()
        Navigator.instance.registerServiceComponentHandler()

    }
}