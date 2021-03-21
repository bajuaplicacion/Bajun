package com.mx.bajun.mobile.homescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.base.BaseActivity
import com.mx.bajun.mobile.utils.Constants.USER_DISPLAY_NAME_KEY
import com.mx.bajun.mobile.utils.Constants.USER_EMAIL_INTENT_KEY


class HomeScreenActivity : BaseActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)
        val tv_user : TextView = findViewById(R.id.tv_user)
        val mDisplayName : String? = intent.getStringExtra(USER_DISPLAY_NAME_KEY)
        val mEmail : String? = intent.getStringExtra(USER_EMAIL_INTENT_KEY)
        "$mDisplayName: $mEmail".also { tv_user.text = it }

        val btnSignOut : Button = findViewById(R.id.btnSignOut)
        btnSignOut.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        signOut(p0?.id)
    }
}