package com.hotelku

import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainContent : AppCompatActivity() {
    private var linearLayout: LinearLayout? = null
    private val menukabkota = arrayOf(
        "BENGKALIS",
        "INHIL",
        "INHU",
        "KAMPAR",
        "KEP.MERANTI",
        "KUANSING",
        "PELELAWAN",
        "ROHIL",
        "SIAK",
        "DUMAI",
        "PEKANBARU"
    )
    private val gambarkabkota = intArrayOf(
        R.drawable.kab_bengkalis,
        R.drawable.kab_inhil,
        R.drawable.kab_inhu,
        R.drawable.kab_kampar,
        R.drawable.kab_kep_meranti,
        R.drawable.kab_kuansing,
        R.drawable.kab_pelelawan,
        R.drawable.kab_rohil,
        R.drawable.kab_rohul,
        R.drawable.kab_siak,
        R.drawable.kota_dumai,
        R.drawable.kota_pekanbaru
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_content)
        linearLayout = findViewById(R.id.linear1)
        val layoutInflater = LayoutInflater.from(this)

        for (i in menukabkota.indices) {
            val view: View = layoutInflater.inflate(R.layout.layout_kabkota, linearLayout, false)
            val imageView = view.findViewById<ImageView>(R.id.iv)
            imageView.setImageResource(gambarkabkota[i])
            val tv = view.findViewById<TextView>(R.id.tv)
            tv.text = menukabkota[i]
            linearLayout?.addView(view)
        }
    }
}