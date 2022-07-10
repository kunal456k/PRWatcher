package com.kunal456k.prwatcher.views

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kunal456k.prwatcher.adapters.PRListAdapter
import com.kunal456k.prwatcher.component.DaggerAppComponent
import com.kunal456k.prwatcher.databinding.PrPageBinding
import com.kunal456k.prwatcher.viewmodels.PRPageViewModel
import javax.inject.Inject

class PRPage : AppCompatActivity() {

    private lateinit var owner: String
    private lateinit var repo: String

    @Inject lateinit var prPageViewModel: PRPageViewModel
    @Inject lateinit var prListAdapter: PRListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init(){
        val binding = PrPageBinding.inflate(layoutInflater)
        binding.lifecycleOwner = this
        setContentView(binding.root)
        DaggerAppComponent.create().getPRPageComponent().inject(this)
        owner = "square"
        repo = "retrofit"
        binding.prPageViewModel = prPageViewModel
        binding.repoOwner = owner
        binding.repoName = repo
        binding.prRecycler.adapter = prListAdapter
        prPageViewModel.startLoadingClosedPRs(owner, repo)
        prPageViewModel.prLiveData.observe(this) {
            Log.d("test", "init: pull requests updated")
            prListAdapter.update(it)
        }
    }
}