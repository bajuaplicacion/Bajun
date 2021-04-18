package com.mx.bajun.mobile.base

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.login.CreateAccountActivity
import com.mx.bajun.mobile.utils.BajunSharedPreferences
import com.mx.bajun.mobile.utils.Common.Companion.isDebugMode
import com.mx.bajun.mobile.utils.Constants
import java.util.*
import kotlin.properties.Delegates

open class BaseActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        super.setContentView(R.layout.activity_base)
        setUI()
        secureScreen()
    }



    override fun onBackPressed() {
        Toast.makeText(this, "Back press", Toast.LENGTH_SHORT).show()
        super.onBackPressed()
    }

    override fun setContentView(view: View?) {
        /*super.setContentView(view)*/
        val params: ViewGroup.LayoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        setContentView(view, params)
    }

    override fun setContentView(view: View?, params: ViewGroup.LayoutParams?) {
        /*super.setContentView(view, params)*/
        val activityContainer: FrameLayout = findViewById(R.id.activity_container)
        activityContainer.addView(view, params)
    }

    override fun setContentView(layoutResID: Int) {
        /*super.setContentView(layoutResID)*/
        val activityContainer: FrameLayout = findViewById(R.id.activity_container)
        val inflater: LayoutInflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val params: ViewGroup.LayoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        val stubView: View = inflater.inflate(layoutResID, activityContainer, false)
        activityContainer.addView(stubView, params)
    }

    private fun setUI() {
       toolbar = findViewById(R.id.base_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back_arrow_white)
    }

    public fun setUpToolbar(bShowBackNavigationButton: Boolean) {
        supportActionBar?.setDisplayShowTitleEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        showBackNavigationButton(bShowBackNavigationButton)
        supportActionBar?.setIcon(R.drawable.ic_baju_app)
    }

    private fun showBackNavigationButton(show: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(show)
        toolbar.setNavigationOnClickListener(View.OnClickListener { backPressButton() })
    }

    public fun changeTitle(title: String) {
        toolbar.title = title
    }

    public fun changeSubTitle(subtTitle: String) {
        toolbar.subtitle = subtTitle
    }

    public fun backPressButton() {
        super.onBackPressed()
    }

    private fun googleSignOut() {
        val gso: GoogleSignInOptions =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build()
        val mGoogleSignInClient: GoogleSignInClient = GoogleSignIn.getClient(this, gso)
        mGoogleSignInClient.signOut().addOnCompleteListener {
            finish()
        }
    }

    private fun emailSignOut() {
        FirebaseAuth.getInstance().signOut()
        finish()
    }

    public fun signOut(viewId: Int?) {
        when (viewId) {
            R.id.menu_exit -> {
                val signInType: String = BajunSharedPreferences.instance.getString(
                    this,
                    Constants.SIGN_IN_TYPE_KEY
                )
                when (signInType) {
                    Constants.GOOGLE_SIGN_IN_TYPE -> googleSignOut()
                    Constants.EMAIL_SIGN_IN_TYPE -> emailSignOut()
                }
            }
        }
    }

    private fun secureScreen() {
        if (!isDebugMode()) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_SECURE,
                WindowManager.LayoutParams.FLAG_SECURE
            )
        }
    }

    public fun isTablet() : Boolean {
        return resources.getBoolean(R.bool.isTablet)
    }

    fun createDialog(cancelable: Boolean, title: String, message: String, negativeText:String, negativeOnClickListener : DialogInterface.OnClickListener,
                            positiveText:String?, positiveOnClickListener : DialogInterface.OnClickListener?) {
        val builder : AlertDialog.Builder = AlertDialog.Builder(this, R.style.CustomAlertDialog)
        builder.setIcon(R.drawable.ic_baju_app)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setCancelable(cancelable)
        builder.setNegativeButton(negativeText, negativeOnClickListener)
        if (positiveOnClickListener != null && !positiveText.isNullOrEmpty()) {
            builder.setPositiveButton(positiveText, positiveOnClickListener)
        }
        builder.create().show()
    }

    public fun createDialog(cancelable: Boolean, title: String, message: String, negativeText:String, negativeOnClickListener : DialogInterface.OnClickListener) {
        createDialog(cancelable, title, message, negativeText, negativeOnClickListener, null, null)
    }

    fun getDisplayLanguage() : String {
        return Locale.getDefault().language
    }

}
