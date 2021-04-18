package com.mx.bajun.mobile.homescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.base.BaseActivity
import com.mx.bajun.mobile.utils.Constants.USER_DISPLAY_NAME_KEY
import com.mx.bajun.mobile.utils.Constants.USER_EMAIL_INTENT_KEY


class HomeScreenActivity : BaseActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)
        setUI()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_diccionario ->  {
                goToDiccionario()
                true
            }
            R.id.menu_redesSociales -> {
                goToRedesSociales()
                true
            }
            R.id.menu_configuracion -> {
                goToConfiguracion()
                true
            }
            R.id.menu_exit -> {
                signOut(R.id.menu_exit)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onClick(p0: View?) {
    }

    private fun setUI() {
        setUpToolbar(false)
        val tv_user : TextView = findViewById(R.id.tv_user)
        val mDisplayName : String? = intent.getStringExtra(USER_DISPLAY_NAME_KEY)
        val mEmail : String? = intent.getStringExtra(USER_EMAIL_INTENT_KEY)
        "$mDisplayName: $mEmail".also { tv_user.text = it }

    }

    private fun goToDiccionario() {Toast.makeText(this, "Diccionario", Toast.LENGTH_LONG).show()}

    private fun goToRedesSociales() {Toast.makeText(this, "Redes sociales", Toast.LENGTH_LONG).show()}

    private fun goToConfiguracion() {Toast.makeText(this, "Configuracion", Toast.LENGTH_LONG).show()}
}