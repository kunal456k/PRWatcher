package com.kunal456k.prwatcher.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kunal456k.prwatcher.services.PRApi
import java.lang.Exception
import javax.inject.Inject

class PullRequestPagingSource constructor(private val prApi: PRApi,
    private val repoOwner: String, private val repoName: String): PagingSource<Int, PullRequest>() {

    companion object{
        const val STARTING_PAGE_NUMBER = 1
    }

    override fun getRefreshKey(state: PagingState<Int, PullRequest>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PullRequest> {
        val page = params.key ?: STARTING_PAGE_NUMBER
        return try {
            val pullRequests = prApi.getOpenPRs(repoOwner, repoName, "closed", page)
            LoadResult.Page(
                data = pullRequests,
                prevKey = if (page == STARTING_PAGE_NUMBER) null else page - 1,
                nextKey = page + 1
            )
        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }

}