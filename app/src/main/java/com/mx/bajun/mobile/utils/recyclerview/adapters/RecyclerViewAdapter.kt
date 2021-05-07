package com.mx.bajun.mobile.utils.recyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mx.bajun.mobile.R
import com.mx.bajun.mobile.utils.model.DataColumn

class RecyclerViewAdapter(private val context: Context, private val elements : List<DataColumn>) : RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>(){
    private val inflater : LayoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view : View = inflater.inflate(R.layout.rv_option_view, parent, false)
        return RecyclerViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.setUI(elements[position])
    }

    override fun getItemCount(): Int {
        return elements.size
    }


    class RecyclerViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        private val cardView : CardView = itemView.findViewById(R.id.rv_cv_options)
        private val imageView : ImageView = itemView.findViewById(R.id.rv_iv_option)
        private val title : TextView = itemView.findViewById(R.id.rv_tv_title)
        private val subTitle : TextView = itemView.findViewById(R.id.rv_tv_subTitle)

        fun setUI(dataColumn: DataColumn) {
            setVisibility(dataColumn)
            itemView.tag = dataColumn.id
            title.text = dataColumn.title
            subTitle.text = dataColumn.subTitle ?: ""
        }

        private fun setVisibility(dataColumn: DataColumn) {
            if (dataColumn.image == null) {
                imageView.visibility = View.GONE
            } else {
                imageView.visibility = View.VISIBLE
            }

            if (dataColumn.subTitle == null) {
                subTitle.visibility = View.GONE
            } else {
                subTitle.visibility = View.VISIBLE
            }

        }
    }
}