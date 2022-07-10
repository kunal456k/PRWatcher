package com.kunal456k.prwatcher.viewmodels

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.kunal456k.prwatcher.component.ActivityScope
import com.kunal456k.prwatcher.data.PullRequest
import com.kunal456k.prwatcher.repository.PRRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ActivityScope
class PRPageViewModel @Inject constructor(private val prRepository: PRRepository) : ViewModel() {

    private var repoOwner: String = ""
    private var repoName: String = ""

    lateinit var pullRequestsFlow: Flow<PagingData<PullRequest>>

    fun loadClosedPRs(repoOwner: String, repoName: String){
        if (this.repoOwner == repoOwner && this.repoName == repoName) return
        this.repoOwner = repoOwner
        this.repoName = repoName
        pullRequestsFlow = prRepository.loadClosedPRs(repoOwner, repoName)
    }
}