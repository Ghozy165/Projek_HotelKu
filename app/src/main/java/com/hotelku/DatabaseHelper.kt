package com.hotelku

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns

class DatabaseHelper(ctx: Context) : SQLiteOpenHelper(ctx,"user.db",null,2) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable : String = "CREATE TABLE user("+
                "${BaseColumns._ID} INTEGER PRIMARY KEY,"+
                "nama TEXT,"+
                "nohp TEXT,"+
                "alamat TEXT,"+
                "email TEXT,"+
                "password TEXT)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS user")
        onCreate(db)
    }
    fun allData() : Cursor{
        val db:SQLiteDatabase = this.writableDatabase
        return db.rawQuery("SELECT * FROM user",null)
    }
}