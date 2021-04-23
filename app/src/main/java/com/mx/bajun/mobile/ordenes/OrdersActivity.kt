package com.mx.bajun.mobile.ordenes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.base.BaseActivity

class OrdersActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)
        setUI()
    }

    private fun setUI() {
        changeTitle(getString(R.string.hs_ordenes))
        setUpToolbar(true)
    }
}