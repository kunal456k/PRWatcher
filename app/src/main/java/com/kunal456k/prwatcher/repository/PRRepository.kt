package com.kunal456k.prwatcher.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.kunal456k.prwatcher.component.ActivityScope
import com.kunal456k.prwatcher.models.PullRequest
import com.kunal456k.prwatcher.services.PRApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@ActivityScope
class PRRepository @Inject constructor(private val prApi: PRApi) {

    companion object{
        const val TAG = "PRRepository"
    }

    fun loadClosedPRs(
        prLiveData: MutableLiveData<List<PullRequest>>,
        message: MutableLiveData<String>,
        owner: String,
        repo: String
    ) {
        val closedPrsRequest  = prApi.getOpenPRs(owner, repo, "closed")
        closedPrsRequest.enqueue(object : Callback<List<PullRequest>>{
            override fun onResponse(call: Call<List<PullRequest>>, response: Response<List<PullRequest>>) {
                Log.d(TAG, "onResponse: ")
                response.body()?.let {
                    prLiveData.postValue(it)
                    Log.d(TAG, "onResponse: $it")
                } ?: run {
                    message.postValue("No data from server")
                }
            }

            override fun onFailure(call: Call<List<PullRequest>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
                message.postValue("Some error occurred")
            }
        })
    }
}