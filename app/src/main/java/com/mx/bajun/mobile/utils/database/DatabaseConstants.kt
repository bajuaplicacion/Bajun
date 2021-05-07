package com.mx.bajun.mobile.utils.database

object DatabaseConstants {

    //Database - configuration
    const val DATABASE_VERSION : Int = 1
    const val DATABASE_NAME : String = "bajunDataBase.db"
    const val DATABASE_CREATE_TABLE : String = "CREATE TABLE IF NOT EXISTS"
    const val DATABASE_DROP_TABLE : String = "DROP TABLE IF EXIST "
    const val DATABASE_PRIMARY_KEY : String = "PRIMARY KEY"
    const val DATABASE_AUTOINCREMENT : String = "AUTOINCREMENT"
    const val DATABASE_TEXT_TYPE : String = "TEXT"
    const val DATABASE_INT_TYPE : String = "INTEGER"
    const val DATABASE_REAL_TYPE : String = "REAL" //FLOAT
    const val DATABASE_BLOB_TYPE : String = "BLOB"

    //Database - tables
    const val DB_DICTIONARY_TABLE : String = "diccionario"
    const val DB_CONVERSION_TABLE : String = "conversion"

    //Database - columns : Dictionary
    const val DB_DICTIONARY_ID : String = "dic_id"
    const val DB_DICTIONARY_NAME : String = "dic_name"

    //Database - columns : Conversion
    const val DB_CONVERSION_ID : String = "conv_id"
    const val DB_CONVERSION_ID_1 : String = "dic_id_1"
    const val DB_CONVERSION_REL_1 : String = "conv_relacion_1"
    const val DB_CONVERSION_ID_2 : String = "dic_id_2"
    const val DB_CONVERSION_REL_2 : String = "conv_relacion_2"

    //Database - create tables
    const val DB_CREATE_DICTIONARY_TABLE : String = "$DATABASE_CREATE_TABLE $DB_DICTIONARY_TABLE " +
            "($DB_DICTIONARY_ID  $DATABASE_INT_TYPE $DATABASE_PRIMARY_KEY $DATABASE_AUTOINCREMENT" +
            ", $DB_DICTIONARY_NAME $DATABASE_TEXT_TYPE)"

    const val DB_CREATE_CONVERSION_TABLE : String = "$DATABASE_CREATE_TABLE $DB_CONVERSION_TABLE " +
            "($DB_CONVERSION_ID $DATABASE_INT_TYPE $DATABASE_PRIMARY_KEY $DATABASE_AUTOINCREMENT" +
            ", $DB_CONVERSION_ID_1 $DATABASE_INT_TYPE, $DB_CONVERSION_REL_1 $DATABASE_REAL_TYPE" +
            ", $DB_CONVERSION_ID_2 $DATABASE_INT_TYPE, $DB_CONVERSION_REL_2 $DATABASE_REAL_TYPE)"

}