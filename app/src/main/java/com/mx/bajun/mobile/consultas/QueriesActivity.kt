package com.mx.bajun.mobile.consultas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.base.BaseActivity

class QueriesActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_queries)
        setUI()
    }

    private fun setUI() {
        changeTitle(getString(R.string.hs_consultas))
        setUpToolbar(true)
    }
}