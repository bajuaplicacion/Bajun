package com.mx.bajun.mobile.utils

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import androidx.core.util.PatternsCompat
import androidx.lifecycle.ReportFragment
import com.mx.bajun.mobile.BuildConfig
import com.mx.bajun.mobile.clientes.ClientsActivity
import com.mx.bajun.mobile.consultas.QueriesActivity
import com.mx.bajun.mobile.emarketing.EMarketingActivity
import com.mx.bajun.mobile.menu.configuracion.SettingsActivity
import com.mx.bajun.mobile.menu.diccionario.ConversionActivity
import com.mx.bajun.mobile.menu.diccionario.DictionaryActivity
import com.mx.bajun.mobile.menu.redesSociales.SocialMediaActivity
import com.mx.bajun.mobile.ordenes.OrdersActivity
import com.mx.bajun.mobile.productos.ProductsActivity
import com.mx.bajun.mobile.promociones.PromotionsActivity
import com.mx.bajun.mobile.proveedores.VendorsActivity
import com.mx.bajun.mobile.reports.ReportsActivity
import com.mx.bajun.mobile.ventas.SalesActivity

class Common {
    companion object {
        fun isValidEmail(sEmail : String):Boolean {
            return (!TextUtils.isEmpty(sEmail) && PatternsCompat.EMAIL_ADDRESS.matcher(sEmail).matches())
        }

        fun isDebugMode() : Boolean {
            return BuildConfig.DEBUG
        }

        fun goToDictionary(context: Context) {
            context.startActivity( Intent(context, DictionaryActivity::class.java) )
        }

        fun goToConversions(context: Context) {
            context.startActivity( Intent(context, ConversionActivity::class.java))
        }

        fun goToSocialMedia(context: Context) {
            context.startActivity(Intent(context, SocialMediaActivity::class.java))
        }

        fun goToSettings(context: Context) {
            context.startActivity(Intent(context, SettingsActivity::class.java))
        }

        fun goToVendors(context: Context) {
            context.startActivity(Intent(context, VendorsActivity::class.java))
        }

        fun goToClients(context: Context){
            context.startActivity(Intent(context, ClientsActivity::class.java))
        }

        fun goToProducts(context: Context) {
            context.startActivity(Intent(context, ProductsActivity::class.java))
        }

        fun goToPromotions(context: Context) {
            context.startActivity(Intent(context, PromotionsActivity::class.java))
        }

        fun goToOrders(context: Context) {
            context.startActivity(Intent(context, OrdersActivity::class.java))
        }

        fun goToSales(context: Context) {
            context.startActivity(Intent(context, SalesActivity::class.java))
        }

        fun goToQueries(context: Context) {
            context.startActivity(Intent(context, QueriesActivity::class.java))
        }

        fun goToReports(context: Context) {
            context.startActivity(Intent(context, ReportsActivity::class.java))
        }

        fun goToEMarketing(context: Context) {
            context.startActivity(Intent(context, EMarketingActivity::class.java))
        }
    }
}