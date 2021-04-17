package com.mx.bajun.mobile.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.utils.Common.Companion.isValidEmail
import com.mx.bajun.mobile.utils.Constants.DISPLAY_LANGUAGE_KEY

class PasswordResetPopUpActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var displayLanguage : String
    private lateinit var closeWindow : ImageView
    private lateinit var errorMessage : TextView
    private lateinit var etEmail : EditText
    private lateinit var bSend : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_passwor_reset)
        setUIDimensions()
        setUI()
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.iv_pr_close_window -> finish()
            R.id.b_pr_send -> sendPasswordResetEmail()
        }
    }

    private fun setUI() {
        displayLanguage = intent.getStringExtra(DISPLAY_LANGUAGE_KEY).toString()
        closeWindow = findViewById(R.id.iv_pr_close_window)
        errorMessage = findViewById(R.id.tv_pr_error)
        etEmail = findViewById(R.id.et_pr_correo)
        bSend = findViewById(R.id.b_pr_send)
        closeWindow.setOnClickListener(this)
        bSend.setOnClickListener(this)
    }

    private fun setUIDimensions(){
        val dm : DisplayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getRealMetrics(dm)
        val width : Int = (dm.widthPixels * .85).toInt()
        val height : Int = (dm.heightPixels * .5).toInt()
        window.setLayout(width, height)
    }

    private fun sendPasswordResetEmail() {
        val email : String = etEmail.text.toString()
        if (isValidEmail(email)) {
            Firebase.auth.languageCode = displayLanguage
            Firebase.auth.sendPasswordResetEmail(email).addOnCompleteListener { it ->
                if (it.isSuccessful) {
                    resetError()
                    finish()
                } else {
                    displayError(getString(R.string.error_email_no_register))
                }
            }
        } else {
            displayError(getString(R.string.error_email_format))
        }
    }

    private fun resetError() {
        errorMessage.text = ""
        errorMessage.visibility = View.INVISIBLE
    }

    private fun displayError(error : String) {
        errorMessage.text = error
        errorMessage.visibility = View.VISIBLE
    }

    companion object {
        const val TAG : String = ""
    }

}