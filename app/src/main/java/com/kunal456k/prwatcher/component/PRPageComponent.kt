package com.kunal456k.prwatcher.component

import com.kunal456k.prwatcher.views.PRPage
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface PRPageComponent {

    fun inject(prPage : PRPage)

}