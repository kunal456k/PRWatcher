package com.kunal456k.prwatcher.component

import com.kunal456k.prwatcher.modules.AppModule
import com.kunal456k.prwatcher.modules.NetworkModule
import com.kunal456k.prwatcher.views.PRPage
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun getPRPageComponent(): PRPageComponent
}