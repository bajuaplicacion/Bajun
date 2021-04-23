package com.mx.bajun.mobile.menu.redesSociales

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.base.BaseActivity

class SocialMediaActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_social_media)
        setUI()
    }

    private fun setUI() {
        changeTitle(getString(R.string.menu_redesSociales))
        setUpToolbar(true)
    }
}