package com.hotelku

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class InformasiHotel : AppCompatActivity() {

    private var linearLayout : LinearLayout? = null
    private var gambar = intArrayOf(R.drawable.grandhotelpku, R.drawable.deluxedoublebed,R.drawable.deluxetwin)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informasihotel)

        linearLayout = findViewById(R.id.img_fotohotel)
        val layoutInflater = LayoutInflater.from(this)

        for (i in gambar.indices){
            val view: View = layoutInflater.inflate(R.layout.layout_gambarinformasihotel,linearLayout,false)
            val imageView = view.findViewById<ImageView>(R.id.iv)
            imageView.setImageResource(gambar[i])
            linearLayout?.addView(view)
        }
    }
}