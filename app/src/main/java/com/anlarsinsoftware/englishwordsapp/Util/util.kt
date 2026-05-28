package com.anlarsinsoftware.englishwordsapp.Util

import android.content.Intent

val DEFAULT_API_KEY = ""

val email_intent = Intent(Intent.ACTION_SEND).apply {
    type = "message/rfc822"
    putExtra(Intent.EXTRA_EMAIL, arrayOf("penlinguapp@gmail.com"))
    putExtra(Intent.EXTRA_SUBJECT, "Geri Bildirim")
    putExtra(Intent.EXTRA_TEXT, "Uygulama hakkında geri bildiriminizi buraya yazabilirsiniz.")
}
