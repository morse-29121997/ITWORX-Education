package com.morse.core.extensions

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

const val fullDateWithTasSeperatorKey = "yyyy-MM-dd'T'HH:mm:ss"
const val fullDateKey = "dd MMM ,yyyy   - hh:mm a"

fun String.convertDateWithTime(locale: Locale = Locale.getDefault(), inputFormat: String = fullDateWithTasSeperatorKey,
                               outPutFormat: String = fullDateKey): String {
    if (this.isNotEmpty()) {
        val parser = SimpleDateFormat(inputFormat, Locale.ENGLISH)
        parser.timeZone = TimeZone.getTimeZone("utc")
        val formatter = SimpleDateFormat(outPutFormat, locale)
        return parser.parse(this)?.let { formatter.format(it) } ?: "-"
    }
    return ""
}