package com.kunal456k.prwatcher.component

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kunal456k.prwatcher.views.PRPage
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface PRPageComponent {
    fun inject(prPage : PRPage)

    @Module
    abstract class ActivityModule {
        @Binds
        abstract fun bindsViewModelFactory(factory: MyViewModelFactory): ViewModelProvider.Factory
    }
}