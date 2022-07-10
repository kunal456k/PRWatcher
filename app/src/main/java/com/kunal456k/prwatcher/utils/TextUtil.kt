package com.kunal456k.prwatcher.utils

import java.text.SimpleDateFormat
import java.time.Instant
import java.util.*

fun getPresentableTime(instant: Instant): String{
    return SimpleDateFormat(PR_DATE_FORMAT, Locale.ENGLISH).format(Date(instant.toEpochMilli()))
}

private const val PR_DATE_FORMAT = "dd-MM-yyyy HH:mm:ss"