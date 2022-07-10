package com.kunal456k.prwatcher.component

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.kunal456k.prwatcher.viewmodels.PRPageViewModel
import javax.inject.Inject
import javax.inject.Provider

class MyViewModelFactory @Inject constructor(private val myViewModelProvider: Provider<PRPageViewModel>) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return myViewModelProvider.get() as T
    }

}