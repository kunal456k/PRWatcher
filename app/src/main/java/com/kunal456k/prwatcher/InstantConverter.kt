package com.kunal456k.prwatcher

import com.google.gson.*
import java.lang.reflect.Type
import java.time.Instant
import java.time.format.DateTimeFormatter

class InstantConverter : JsonSerializer<Instant>, JsonDeserializer<Instant> {
    private val formatter: DateTimeFormatter = DateTimeFormatter.ISO_INSTANT

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): Instant {
        return Instant.parse(json?.asString)
    }

    override fun serialize(
        src: Instant?,
        typeOfSrc: Type?,
        context: JsonSerializationContext?
    ): JsonElement {
        return JsonPrimitive(formatter.format(src))
    }
}