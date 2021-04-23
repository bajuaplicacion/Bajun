package com.mx.bajun.mobile.clientes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.base.BaseActivity

class ClientsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clients)
        setUI()
    }

    private fun setUI() {
        changeTitle(getString(R.string.hs_clientes))
        setUpToolbar(true)
    }
}