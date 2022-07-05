package com.kunal456k.prwatcher.models

import com.google.gson.annotations.SerializedName
import java.time.Instant

data class PullRequest(
     @SerializedName("url") val url: String,
     @SerializedName("id") val id: Long,
     @SerializedName("html_url") val htmlUrl: String,
     @SerializedName("issue_url") val issueUrl: String,
     @SerializedName("number") val prNumber: Int,
     @SerializedName("state") val state: String,
     @SerializedName("title") val title: String,
     @SerializedName("user") val user : User,
     @SerializedName("created_at") val created: Instant,
     @SerializedName("closed_at") val closed: Instant
    )