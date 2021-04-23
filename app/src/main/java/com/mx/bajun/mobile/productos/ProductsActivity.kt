package com.mx.bajun.mobile.productos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.base.BaseActivity

class ProductsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)
        setUI()
    }

    private fun setUI() {
        changeTitle(getString(R.string.hs_productos))
        setUpToolbar(true)
    }
}