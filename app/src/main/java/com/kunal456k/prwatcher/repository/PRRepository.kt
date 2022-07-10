package com.kunal456k.prwatcher.repository

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kunal456k.prwatcher.component.ActivityScope
import com.kunal456k.prwatcher.data.PullRequest
import com.kunal456k.prwatcher.data.PullRequestPagingSource
import com.kunal456k.prwatcher.services.PRApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ActivityScope
class PRRepository @Inject constructor(private val prApi: PRApi) {

    companion object{
        const val TAG = "PRRepository"
    }

    fun loadClosedPRs(
        owner: String,
        repo: String
    ) : Flow<PagingData<PullRequest>> {

        return Pager(
            config = PagingConfig(30)
        ){
            PullRequestPagingSource(prApi, owner, repo)
        }.flow
    }
}