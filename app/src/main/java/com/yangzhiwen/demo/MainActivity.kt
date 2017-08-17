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
        findViewById<Button>(R.id.center).setOnClickListener {
            Navigator.instance.startActivity("user_center", "center", "arg")
        }
    }
}
