package com.kunal456k.prwatcher.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kunal456k.prwatcher.component.ActivityScope
import com.kunal456k.prwatcher.models.PullRequest
import com.kunal456k.prwatcher.repository.PRRepository
import javax.inject.Inject

@ActivityScope
class PRPageViewModel @Inject constructor(private val prRepository: PRRepository){

    fun startLoadingClosedPRs(owner: String, repo: String) {
        prRepository.loadClosedPRs(prLiveData as MutableLiveData, message as MutableLiveData, owner, repo)
    }

    val prLiveData: LiveData<List<PullRequest>> = MutableLiveData()
    val message: LiveData<String> = MutableLiveData()
}