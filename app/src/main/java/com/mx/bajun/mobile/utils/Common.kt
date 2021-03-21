package com.mx.bajun.mobile.utils

import android.text.TextUtils
import androidx.core.util.PatternsCompat
import com.mx.bajun.mobile.BuildConfig

class Common {
    companion object {
        fun isValidEmail(sEmail : String):Boolean {
            return (!TextUtils.isEmpty(sEmail) && PatternsCompat.EMAIL_ADDRESS.matcher(sEmail).matches())
        }

        fun isDebugMode() : Boolean {
            return BuildConfig.DEBUG
        }
    }
}