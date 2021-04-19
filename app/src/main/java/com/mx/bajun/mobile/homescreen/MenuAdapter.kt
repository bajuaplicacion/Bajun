package com.mx.bajun.mobile.homescreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.homescreen.model.MenuOptions

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
                holder.tag = MenuOptions.PROVEEDORES.titleId
                holder.image.setImageResource(R.drawable.ic_contact_page_blue)
            }
            MenuOptions.CLIENTES.titleId -> {
                holder.title.text = context.getString(R.string.hs_clientes)
                holder.tag = MenuOptions.CLIENTES.titleId
                holder.image.setImageResource(R.drawable.ic_contact_page_blue)
            }
            MenuOptions.PRODUCTOS.titleId -> {
                holder.title.text = context.getString(R.string.hs_productos)
                holder.tag = MenuOptions.PRODUCTOS.titleId
                holder.image.setImageResource(R.drawable.ic_backpack_blue)
            }
            MenuOptions.PROMOCIONES.titleId -> {
                holder.title.text = context.getString(R.string.hs_promociones)
                holder.tag = MenuOptions.PROMOCIONES.titleId
                holder.image.setImageResource(R.drawable.ic_backpack_blue)
            }
            MenuOptions.ORDENES.titleId -> {
                holder.title.text = context.getString(R.string.hs_ordenes)
                holder.tag = MenuOptions.ORDENES.titleId
                holder.image.setImageResource(R.drawable.ic_backup_blue)
            }
            MenuOptions.VENTAS.titleId -> {
                holder.title.text = context.getString(R.string.hs_ventas)
                holder.tag = MenuOptions.VENTAS.titleId
                holder.image.setImageResource(R.drawable.ic_calculate_blue)
            }
            MenuOptions.CONSULTAS.titleId -> {
                holder.title.text = context.getString(R.string.hs_consultas)
                holder.tag = MenuOptions.CONSULTAS.titleId
                holder.image.setImageResource(R.drawable.ic_manage_search_blue)
            }
            MenuOptions.REPORETES.titleId -> {
                holder.title.text = context.getString(R.string.hs_reportes)
                holder.tag = MenuOptions.REPORETES.titleId
                holder.image.setImageResource(R.drawable.ic_query_stats_blue)
            }
            MenuOptions.EMARKETIN.titleId -> {
                holder.title.text = context.getString(R.string.hs_eMarketing)
                holder.tag = MenuOptions.EMARKETIN.titleId
                holder.image.setImageResource(R.drawable.ic_wifi_tethering_blue)
            }
        }
    }

    override fun getItemCount(): Int {
        return options.size
    }

    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView = itemView.findViewById(R.id.iv_mo_title)
        val image : ImageView = itemView.findViewById(R.id.iv_mo_image)
        var tag : Int = -1
        init {
            itemView.setOnClickListener(View.OnClickListener {

            })
        }
    }

}


