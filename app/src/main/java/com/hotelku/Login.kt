package com.hotelku

import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Login:AppCompatActivity() {
    lateinit var btnLogin: Button
    lateinit var txtEmail: EditText
    lateinit var txtPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()

        btnLogin.setOnClickListener {
            val dbHelper = DatabaseHelper(this)
            val cursor: Cursor = dbHelper.allData()

            var flag = 0
            while (cursor.moveToNext()){
                if(txtEmail.text.toString().equals(cursor.getString(4))&&txtPassword.text.toString().equals(cursor.getString(5))){
                    flag =1
                    val intent = Intent(this,MainActivity::class.java)
                    startActivity(intent)
                    break
                }
            }
            if(flag == 0){
                Toast.makeText(this,"User Not found!", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun init() {
        btnLogin = findViewById(R.id.btn_login)
        txtEmail = findViewById(R.id.edt_email)
        txtPassword = findViewById(R.id.edt_password)
    }
}