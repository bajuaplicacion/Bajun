package com.mx.bajun.mobile.reports

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.base.BaseActivity

class ReportsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reports)
        setUI()
    }

    private fun setUI() {
        changeTitle(getString(R.string.hs_reportes))
        setUpToolbar(true)
    }
}