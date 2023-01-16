package com.hotelku

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_hal_daftar_hotel.*

class HalPemHo : AppCompatActivity() {
    //Deklarasi variabel
    private var layoutManager: RecyclerView.LayoutManager?=null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pemesanan_hotel)

    }

    fun kembaliKeHalamanInformasiHotel(view: View?){
        val i = Intent(applicationContext, InformasiHotel::class.java)
        startActivity(i)
    }

}