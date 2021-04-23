package com.mx.bajun.mobile.ventas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.base.BaseActivity

class SalesActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sales)
        setUI()
    }

    private fun setUI() {
        changeTitle(getString(R.string.hs_ventas))
        setUpToolbar(true)
    }
}