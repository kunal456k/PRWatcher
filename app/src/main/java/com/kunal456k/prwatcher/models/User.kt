package com.kunal456k.prwatcher.models

import com.google.gson.annotations.SerializedName

data class User constructor(
    @SerializedName("login") val name: String,
    @SerializedName("avatar_url") val avatarUrl: String,
    @SerializedName("html_url") val profileUrl: String,
)