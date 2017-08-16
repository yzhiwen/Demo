package com.yangzhiwen.demo

import android.graphics.drawable.Drawable

/**
 * Created by yangzhiwen on 17/8/16.
 */
class Bus {
    companion object {
        val instance = Bus()
    }

    var centerActivity: CenterActivity? = null

    fun register(activity: CenterActivity) {
        centerActivity = activity
    }

    fun post(d: Drawable) {
        centerActivity?.onEvent(d)
    }
}