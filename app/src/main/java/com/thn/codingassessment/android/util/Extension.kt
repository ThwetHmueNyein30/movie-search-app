package com.thn.codingassessment.android.util

fun String.formatYear(): String {
    return if (this.contains("–")) {
        val parts = this.split("–")
        if (parts.size == 2 && parts[1].isNotEmpty()) {
            this
        } else {
            parts[0].replace("–","")
        }
    } else {
        this
    }
}
