package com.mx.bajun.mobile.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.base.BaseActivity
import com.mx.bajun.mobile.homescreen.HomeScreenActivity
import com.mx.bajun.mobile.utils.BajunSharedPreferences
import com.mx.bajun.mobile.utils.Common.Companion.isValidEmail
import com.mx.bajun.mobile.utils.Constants
import com.mx.bajun.mobile.utils.Constants.CREATE_ACCOUNT_RESULT_ID
import com.mx.bajun.mobile.utils.Constants.DISPLAY_LANGUAGE_KEY
import com.mx.bajun.mobile.utils.Constants.SUCCESS_ID

class FirebaseAuthLoginActivity : BaseActivity(), View.OnClickListener, View.OnFocusChangeListener {

    private lateinit var etCorreo : EditText
    private lateinit var etPassword : EditText
    private lateinit var btnIngresar : Button
    private lateinit var tvCrearCuenta : TextView
    private lateinit var tvErrorMessage : TextView
    private lateinit var tvForgotPassword : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_auth_login)
        init()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_ingresar -> login()
            R.id.tv_crearCuenta -> goToCreaCuenta()
            R.id.tv_forgotPassword -> showPasswordResetPopUp()
        }
    }

    override fun onFocusChange(p0: View?, hasFocus: Boolean) {
        when (p0?.id) {
            R.id.et_correo -> if (!hasFocus)  checkEmailFormat()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            CREATE_ACCOUNT_RESULT_ID -> {
                Log.d(TAG, "onActivityResult - create account")
                when (resultCode) {
                    SUCCESS_ID -> setResult(SUCCESS_ID)
                    //FAILURE_ID -> setResult(FAILURE_ID)
                }
                finish()
            }
        }
    }

    private fun init() {
        setUpToolbar(true)
        etCorreo = findViewById(R.id.et_correo)
        etPassword = findViewById(R.id.et_password)
        btnIngresar  = findViewById(R.id.btn_ingresar)
        tvCrearCuenta = findViewById(R.id.tv_crearCuenta)
        tvErrorMessage = findViewById(R.id.tv_errorMessage)
        tvForgotPassword = findViewById(R.id.tv_forgotPassword)
        etCorreo.onFocusChangeListener = this
        btnIngresar.setOnClickListener(this)
        btnIngresar.isEnabled = false
        tvCrearCuenta.setOnClickListener(this)
        tvForgotPassword.setOnClickListener(this)
    }

    private fun checkEmailFormat() {
        val sEmail : String = etCorreo.text.toString()
        if (!isValidEmail(sEmail)) {
            errorMessage(R.id.et_correo, getString(R.string.error_email_format) )
        } else {
            resetError(R.id.et_correo)
        }
    }

    private fun goToHomeScreen(displayName : String?, email : String?) {
        val homeScreenIntent : Intent = Intent(this, HomeScreenActivity::class.java).apply {
            putExtra(Constants.USER_DISPLAY_NAME_KEY, displayName)
            putExtra(Constants.USER_EMAIL_INTENT_KEY, email)
        }
        startActivity(homeScreenIntent)
    }

    private fun goToCreaCuenta() {
        val crearCuentaIntent : Intent = Intent(this, CreateAccountActivity::class.java)
        startActivityForResult(crearCuentaIntent, CREATE_ACCOUNT_RESULT_ID)
    }

    private fun errorMessage(viewId:Int, message : String) {
        tvErrorMessage.text = message
        tvErrorMessage.visibility = View.VISIBLE
        if (viewId == R.id.et_correo) {
            etCorreo.setBackgroundResource(R.drawable.error_background)
            btnIngresar.isEnabled = false
        } else {
            etPassword.setBackgroundResource(R.drawable.error_background)
        }
    }

    private fun resetError(viewId: Int) {
        tvErrorMessage.visibility = View.INVISIBLE
        if (viewId == R.id.et_correo) {
            etCorreo.setBackgroundResource(R.drawable.white_background)
            btnIngresar.isEnabled = true
        } else {
            etPassword.setBackgroundResource(R.drawable.white_background)
        }
    }

    private fun login() {
        val email : String = etCorreo.text.toString()
        val password : String = etPassword.text.toString()
        val auth : FirebaseAuth = FirebaseAuth.getInstance()
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task : Task<AuthResult> ->
                if (task.isSuccessful) {
                    BajunSharedPreferences.instance.setString(this, Constants.SIGN_IN_TYPE_KEY, Constants.EMAIL_SIGN_IN_TYPE )
                    resetError(R.id.et_password)
                    setResult(SUCCESS_ID)
                    finish()
                } else {
                    Log.d(TAG, "login: " + task.exception.toString())
                    when (task.exception) {
                        is FirebaseAuthInvalidCredentialsException -> errorMessage(R.id.et_password, getString(R.string.error_contrasenia_incorrecta))
                    }
                }
            }

    }

    private fun showPasswordResetPopUp() {
        val passwordResetIntent : Intent = Intent(this, PasswordResetPopUpActivity::class.java)
        passwordResetIntent.putExtra(DISPLAY_LANGUAGE_KEY, getDisplayLanguage())
        startActivity(passwordResetIntent)
    }

    companion object {
        const val TAG : String = "FBALoginActivity"
    }
}