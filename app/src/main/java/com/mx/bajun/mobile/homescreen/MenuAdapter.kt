package com.mx.bajun.mobile.homescreen

import android.content.Context
import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.homescreen.model.MenuOptions
import com.mx.bajun.mobile.utils.Common
import com.mx.bajun.mobile.utils.Utils

class MenuAdapter(private var context: Context, private var options: List<Int>) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    private var inflater : LayoutInflater = LayoutInflater.from(context)
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view: View = inflater.inflate(R.layout.hs_option_view, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        when (options[position]) {
            MenuOptions.PROVEEDORES.titleId -> {
                holder.title.text = context.getString(R.string.hs_proveedores)
                holder.itemView.tag = MenuOptions.PROVEEDORES.titleId
                holder.image.setImageResource(R.drawable.ic_proveedores_blue)
            }
            MenuOptions.CLIENTES.titleId -> {
                holder.title.text = context.getString(R.string.hs_clientes)
                holder.itemView.tag = MenuOptions.CLIENTES.titleId
                holder.image.setImageResource(R.drawable.ic_clientes_blue)
            }
            MenuOptions.PRODUCTOS.titleId -> {
                holder.title.text = context.getString(R.string.hs_productos)
                holder.itemView.tag = MenuOptions.PRODUCTOS.titleId
                holder.image.setImageResource(R.drawable.ic_productos_blue)
            }
            MenuOptions.PROMOCIONES.titleId -> {
                holder.title.text = context.getString(R.string.hs_promociones)
                holder.itemView.tag = MenuOptions.PROMOCIONES.titleId
                holder.image.setImageResource(R.drawable.ic_promociones_blue)
            }
            MenuOptions.ORDENES.titleId -> {
                holder.title.text = context.getString(R.string.hs_ordenes)
                holder.itemView.tag = MenuOptions.ORDENES.titleId
                holder.image.setImageResource(R.drawable.ic_ordenes_blue)
            }
            MenuOptions.VENTAS.titleId -> {
                holder.title.text = context.getString(R.string.hs_ventas)
                holder.itemView.tag = MenuOptions.VENTAS.titleId
                holder.image.setImageResource(R.drawable.ic_ventas_blue)
            }
            MenuOptions.CONSULTAS.titleId -> {
                holder.title.text = context.getString(R.string.hs_consultas)
                holder.itemView.tag = MenuOptions.CONSULTAS.titleId
                holder.image.setImageResource(R.drawable.ic_busquedas_blue)
            }
            MenuOptions.REPORETES.titleId -> {
                holder.title.text = context.getString(R.string.hs_reportes)
                holder.itemView.tag = MenuOptions.REPORETES.titleId
                holder.image.setImageResource(R.drawable.ic_reportes_blue)
            }
            MenuOptions.EMARKETIN.titleId -> {
                holder.title.text = context.getString(R.string.hs_eMarketing)
                holder.itemView.tag = MenuOptions.EMARKETIN.titleId
                holder.image.setImageResource(R.drawable.ic_emarketing_blue)
            }
        }
    }

    override fun getItemCount(): Int {
        return options.size
    }


    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val container : CardView = itemView.findViewById(R.id.cv_mo_container)
        val information : ImageView = itemView.findViewById(R.id.iv_mo_information)
        val title : TextView = itemView.findViewById(R.id.iv_mo_title)
        val image : ImageView = itemView.findViewById(R.id.iv_mo_image)

        init {
            information.setOnClickListener(setInformationOnClick())
            container.setOnClickListener(setCardViewOnClick())
        }

        private fun setInformationOnClick() : View.OnClickListener {
            return View.OnClickListener {
                when (adapterPosition) {
                    MenuOptions.PROVEEDORES.titleId -> dialog(it.context, it.context.getString(R.string.hs_proveedores), "Informacion del modulo de proveedores")
                    MenuOptions.CLIENTES.titleId -> dialog(it.context, it.context.getString(R.string.hs_clientes), "Informacion del modulo de clientes")
                    MenuOptions.PRODUCTOS.titleId -> dialog(it.context, it.context.getString(R.string.hs_productos), "Informacion del modulo de productos")
                    MenuOptions.PROMOCIONES.titleId -> dialog(it.context, it.context.getString(R.string.hs_promociones), "Informacion del modulo de promociones")
                    MenuOptions.ORDENES.titleId -> dialog(it.context, it.context.getString(R.string.hs_ordenes), "Informacion del modulo de ordenes")
                    MenuOptions.VENTAS.titleId -> dialog(it.context, it.context.getString(R.string.hs_ventas), "Informacion del modulo de ventas")
                    MenuOptions.CONSULTAS.titleId -> dialog(it.context, it.context.getString(R.string.hs_consultas), "Informacion del modulo de consultas")
                    MenuOptions.REPORETES.titleId -> dialog(it.context, it.context.getString(R.string.hs_reportes), "Informacion del modulo de reportes")
                    MenuOptions.EMARKETIN.titleId -> dialog(it.context, it.context.getString(R.string.hs_eMarketing), "Informacion del modulo de E-Marketing")
                }
            }
        }

        private fun setCardViewOnClick() : View.OnClickListener {
            return View.OnClickListener {
                when(adapterPosition) {
                    MenuOptions.PROVEEDORES.titleId -> Common.goToVendors(it.context)
                    MenuOptions.PRODUCTOS.titleId -> Common.goToProducts(it.context)
                    MenuOptions.CLIENTES.titleId -> Common.goToClients(it.context)
                    MenuOptions.PROMOCIONES.titleId -> Common.goToPromotions(it.context)
                    MenuOptions.ORDENES.titleId -> Common.goToOrders(it.context)
                    MenuOptions.VENTAS.titleId -> Common.goToSales(it.context)
                    MenuOptions.CONSULTAS.titleId -> Common.goToQueries(it.context)
                    MenuOptions.REPORETES.titleId -> Common.goToReports(it.context)
                    MenuOptions.EMARKETIN.titleId -> Common.goToEMarketing(it.context)
                }
            }
        }

        private fun dialog(context: Context, title:String, message:String) {
            Utils.Companion.createDialog(context, true, title,message, context.getString(R.string.ok),
                DialogInterface.OnClickListener{ dialog, _ ->  dialog.dismiss() })
        }
    }

}


