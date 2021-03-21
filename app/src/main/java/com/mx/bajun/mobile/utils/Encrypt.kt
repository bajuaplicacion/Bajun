package com.mx.bajun.mobile.utils

import android.os.Build
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.security.keystore.KeyProperties.*
import android.text.TextUtils
import androidx.annotation.RequiresApi
import com.mx.bajun.mobile.utils.Constants.EMPTY_STRING
import java.lang.Exception
import javax.crypto.KeyGenerator

class Encrypt private constructor(){
    companion object {
        private const val BAJUN_ALIAS = "BajunSecureKey"
        private var keyStore : EncryptCore? = null
        private var INSTANCE : Encrypt ? = null
        val instance : Encrypt
            get() {
               if (INSTANCE == null) {
                   INSTANCE = Encrypt()
               }
                if (keyStore == null) {
                    keyStore = EncryptCore()
                }
                return INSTANCE as Encrypt
            }

    }
    fun encryptMessage (message : String) : String? {
        if (message.isEmpty()) {
            return EMPTY_STRING
        }
        keyStore?.generateKey(BAJUN_ALIAS)
        return keyStore?.encrypt(message, BAJUN_ALIAS)
    }

    fun decryptMessage (encryptedMessage : String) : String? {
        if (encryptedMessage.isEmpty()) {
            return EMPTY_STRING
        }
        return keyStore?.decrypt(encryptedMessage, BAJUN_ALIAS)
    }
}