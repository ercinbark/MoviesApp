package com.ercin.movies.util

import android.content.Context
import android.os.Build
import java.util.*

class DeviceUtils(private val context:Context) {

    val locale: Locale
        get() {
            return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                context.resources.configuration.locales[0]
            } else {
                @Suppress("DEPRECATION")
                context.resources.configuration.locale
            }
        }

    val local: String
        get() = when (val lang = locale.language) {
            "iw" -> "he"
            "in" -> "id"
            else -> lang
        }

    val localeCountry: String
        get() {
            return locale.country
        }

}