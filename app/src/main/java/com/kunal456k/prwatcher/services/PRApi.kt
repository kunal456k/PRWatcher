package com.kunal456k.prwatcher.services

import com.kunal456k.prwatcher.data.PullRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PRApi {

    @GET("{owner}/{repo}/pulls")
    suspend fun getOpenPRs(@Path("owner") owner: String, @Path("repo") repo: String, @Query("state") state: String
    , @Query("page") page: Int = 1) : List<PullRequest>

}