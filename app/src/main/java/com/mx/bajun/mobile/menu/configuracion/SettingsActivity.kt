package com.mx.bajun.mobile.menu.configuracion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.base.BaseActivity

class SettingsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setUI()
    }

    private fun setUI() {
        changeTitle(getString(R.string.menu_configuracion))
        setUpToolbar(true)
    }
}