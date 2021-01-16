package com.hendev.notes

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class VeritabaniYardimcisi(context: Context) : SQLiteOpenHelper(context,"BasicDB.sqlite",null,1) {

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE IF NOT EXISTS BasicDataClass(id INTEGER PRIMARY KEY AUTOINCREMENT, column1 TEXT, column2 INTEGER, column3 INTEGER);")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS BasicDataClass")
        onCreate(db)
    }
}