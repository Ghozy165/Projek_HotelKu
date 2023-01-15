package com.hotelku

import android.content.ContentValues
import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Registrasi : AppCompatActivity() {
    lateinit var txtNama : EditText
    lateinit var txtNohp : EditText
    lateinit var txtAlamat : EditText
    lateinit var txtEmail : EditText
    lateinit var txtPassword : EditText
    lateinit var btnDaftar :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regis)

        init()
        btnDaftar.setOnClickListener{
            if (!txtEmail.text.toString().contains("@")){
                Toast.makeText(this,"Email Valid",Toast.LENGTH_SHORT).show()

            }else{
                addUserToDatabase()
                val intent = Intent(this,Login::class.java)
                startActivity(intent)
            }
        }
    }
    private fun addUserToDatabase(){
        val dbHelper = DatabaseHelper(this)
        val db : SQLiteDatabase = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put("email", txtEmail.text.toString())
            put("password", txtPassword.text.toString())
        }
        db.insert("user",null,values)
    }
    private fun init(){
        txtNama = findViewById(R.id.edt_nama)
        txtNohp = findViewById(R.id.edt_nohp)
        txtAlamat = findViewById(R.id.edt_alamat)
        txtEmail = findViewById(R.id.edt_email)
        txtPassword = findViewById(R.id.edt_password)
        btnDaftar = findViewById(R.id.btn_regis)
    }
}