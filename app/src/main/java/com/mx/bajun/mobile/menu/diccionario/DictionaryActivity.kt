package com.mx.bajun.mobile.menu.diccionario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.base.BaseActivity

class DictionaryActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dictionary)
        setUI()
    }

    private fun setUI() {
        changeTitle(getString(R.string.menu_diccionario))
        setUpToolbar(true)
    }
}