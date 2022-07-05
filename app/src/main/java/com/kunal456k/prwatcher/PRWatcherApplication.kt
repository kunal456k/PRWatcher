package com.kunal456k.prwatcher

import android.app.Application
import com.kunal456k.prwatcher.component.DaggerAppComponent
import com.kunal456k.prwatcher.modules.AppModule
import com.kunal456k.prwatcher.modules.NetworkModule

class PRWatcherApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .appModule(AppModule(this)).build()
    }

}