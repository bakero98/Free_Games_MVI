package com.balsa.free_games_mvi.data.serialization

import com.squareup.moshi.FromJson
import com.squareup.moshi.ToJson
import org.threeten.bp.DateTimeException
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.format.DateTimeParseException

class OffsetDateTimeAdapter {

    @ToJson
    fun toJson(dateTime: OffsetDateTime): String? {
        return try {
            FORMATTER.format(dateTime)
        } catch (e: DateTimeException) {
            null
        }
    }

    @FromJson
    fun fromJson(json: String): OffsetDateTime? {
        return try {
            FORMATTER.parse(json, OffsetDateTime.FROM)
        } catch (e: DateTimeParseException) {
            null
        }
    }

    companion object {
        private val FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    }
}