package com.webaddicted.jetpackcomposedemo.utils.common


import android.app.Application

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
//        PreferenceUtils.getInstance(this)
//        if(BuildConfig.DEBUG)
//        Stetho.initializeWithDefaults(this)
    }
}