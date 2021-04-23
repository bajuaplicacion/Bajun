package com.mx.bajun.mobile.emarketing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.base.BaseActivity

class EMarketingActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_e_marketing)
        setUI()
    }

    private fun setUI() {
        changeTitle(getString(R.string.hs_eMarketing))
        setUpToolbar(true)
    }
}