package com.mx.bajun.mobile.promociones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.base.BaseActivity

class PromotionsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_promotions)
        setUI()
    }

    private fun setUI() {
        changeTitle(getString(R.string.hs_promociones))
        setUpToolbar(true)
    }
}