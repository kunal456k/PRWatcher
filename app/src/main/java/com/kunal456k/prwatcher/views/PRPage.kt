package com.kunal456k.prwatcher.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.kunal456k.prwatcher.adapters.PRListAdapter
import com.kunal456k.prwatcher.component.DaggerAppComponent
import com.kunal456k.prwatcher.component.MyViewModelFactory
import com.kunal456k.prwatcher.databinding.PrPageBinding
import com.kunal456k.prwatcher.viewmodels.PRPageViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class PRPage : AppCompatActivity() {

    private lateinit var owner: String
    private lateinit var repo: String

    @Inject lateinit var factory: MyViewModelFactory
    lateinit var prPageViewModel: PRPageViewModel
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
        prPageViewModel = ViewModelProvider(this, factory).get(PRPageViewModel::class.java)
        binding.prPageViewModel = prPageViewModel
        binding.repoOwner = owner
        binding.repoName = repo
        binding.prRecycler.adapter = prListAdapter
        prPageViewModel.loadClosedPRs(owner, repo)
        lifecycleScope.launch {
            prPageViewModel.pullRequestsFlow.collectLatest { pagingData ->
                prListAdapter.submitData(pagingData)
            }
        }
    }
}