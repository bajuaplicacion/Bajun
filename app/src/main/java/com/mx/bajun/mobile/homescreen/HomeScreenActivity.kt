package com.mx.bajun.mobile.homescreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.base.BaseActivity
import com.mx.bajun.mobile.homescreen.model.MenuOptions
import com.mx.bajun.mobile.homescreen.model.OptionItemDecorator
import com.mx.bajun.mobile.utils.Common
import com.mx.bajun.mobile.utils.Constants.USER_DISPLAY_NAME_KEY
import com.mx.bajun.mobile.utils.Constants.USER_EMAIL_INTENT_KEY


class HomeScreenActivity : BaseActivity(), View.OnClickListener {

    private lateinit var homeScreenOptions : RecyclerView
    private lateinit var tv_user : TextView
    private lateinit var options : List<Int>
    private lateinit var menuAdapter: MenuAdapter
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
                Common.goToDictionary(this)
                true
            }
            R.id.menu_redesSociales -> {
                Common.goToSocialMedia(this)
                true
            }
            R.id.menu_configuracion -> {
                Common.goToSettings(this)
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
        tv_user  = findViewById(R.id.tv_user)
        homeScreenOptions = findViewById(R.id.rv_hs_options)
        val mDisplayName : String? = intent.getStringExtra(USER_DISPLAY_NAME_KEY)
        (getString(R.string.hs_welcome) + " " +"$mDisplayName").also { tv_user.text =  it }
        options = listOf(MenuOptions.PROVEEDORES.titleId, MenuOptions.CLIENTES.titleId, MenuOptions.PRODUCTOS.titleId,
            MenuOptions.PROMOCIONES.titleId, MenuOptions.ORDENES.titleId, MenuOptions.VENTAS.titleId, MenuOptions.CONSULTAS.titleId,
            MenuOptions.REPORETES.titleId, MenuOptions.EMARKETIN.titleId)
        menuAdapter = MenuAdapter(this, options)

        val gridLayoutManager : GridLayoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        homeScreenOptions.layoutManager = gridLayoutManager
        homeScreenOptions.addItemDecoration(OptionItemDecorator(resources.getDimension(R.dimen.mo_rv_cardvie_separator).toInt()))
        homeScreenOptions.adapter = menuAdapter


    }

}