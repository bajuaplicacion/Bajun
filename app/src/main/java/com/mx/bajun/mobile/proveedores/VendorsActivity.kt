package com.mx.bajun.mobile.proveedores

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.base.BaseActivity

class VendorsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vendors)
        setUI()
    }

    private fun setUI() {
        changeTitle(getString(R.string.hs_proveedores))
        setUpToolbar(true)
    }
}