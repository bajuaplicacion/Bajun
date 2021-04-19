package com.mx.bajun.mobile.utils

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import com.mx.bajun.mobile.R

class Utils {
    companion object {
        fun createDialog(context: Context, cancelable: Boolean, title: String, message: String, negativeText:String, negativeOnClickListener : DialogInterface.OnClickListener,
                         positiveText:String?, positiveOnClickListener : DialogInterface.OnClickListener?) {
            val builder : AlertDialog.Builder = AlertDialog.Builder(context, R.style.CustomAlertDialog)
            builder.setIcon(R.drawable.ic_baju_app)
            builder.setTitle(title)
            builder.setMessage(message)
            builder.setCancelable(cancelable)
            builder.setNegativeButton(negativeText, negativeOnClickListener)
            if (positiveOnClickListener != null && !positiveText.isNullOrEmpty()) {
                builder.setPositiveButton(positiveText, positiveOnClickListener)
            }
            builder.create().show()
        }


        public fun createDialog(context: Context, cancelable: Boolean, title: String, message: String, negativeText:String, negativeOnClickListener : DialogInterface.OnClickListener) {
            createDialog(context, cancelable, title, message, negativeText, negativeOnClickListener, null, null)
        }
    }
}