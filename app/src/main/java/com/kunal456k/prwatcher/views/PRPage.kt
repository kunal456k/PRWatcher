package com.kunal456k.prwatcher.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.kunal456k.prwatcher.component.DaggerAppComponent
import com.kunal456k.prwatcher.databinding.PrPageBinding
import com.kunal456k.prwatcher.viewmodels.PRPageViewModel
import javax.inject.Inject

class PRPage : AppCompatActivity() {

    @Inject lateinit var prPageViewModel: PRPageViewModel

    lateinit var owner: String
    lateinit var repo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init(){
        val binding = PrPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DaggerAppComponent.create().getPRPageComponent().inject(this)
        binding.prPageViewModel = prPageViewModel
        owner = "square"
        repo = "retrofit"
        prPageViewModel.startLoadingClosedPRs(owner, repo)
        prPageViewModel.prLiveData.observe(this, Observer{

        })
    }
}