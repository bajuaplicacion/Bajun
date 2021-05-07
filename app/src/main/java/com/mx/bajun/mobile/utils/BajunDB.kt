package com.mx.bajun.mobile.utils

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.mx.bajun.mobile.utils.DatabaseConstants.DATABASE_DROP_TABLE
import com.mx.bajun.mobile.utils.DatabaseConstants.DATABASE_NAME
import com.mx.bajun.mobile.utils.DatabaseConstants.DATABASE_VERSION
import com.mx.bajun.mobile.utils.DatabaseConstants.DB_CONVERSION_TABLE
import com.mx.bajun.mobile.utils.DatabaseConstants.DB_CREATE_CONVERSION_TABLE
import com.mx.bajun.mobile.utils.DatabaseConstants.DB_CREATE_DICTIONARY_TABLE
import com.mx.bajun.mobile.utils.DatabaseConstants.DB_DICTIONARY_TABLE

class BajunDB (context: Context, name: String = DATABASE_NAME, factory: SQLiteDatabase.CursorFactory? = null, version: Int = DATABASE_VERSION) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(DB_CREATE_DICTIONARY_TABLE)
        db?.execSQL(DB_CREATE_CONVERSION_TABLE)

        insertUnitDefaults(db)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DATABASE_DROP_TABLE + DB_CONVERSION_TABLE)
        db?.execSQL(DATABASE_DROP_TABLE + DB_DICTIONARY_TABLE)
        onCreate(db)
    }

    private fun insertUnitDefaults(db : SQLiteDatabase?) {

    }
}