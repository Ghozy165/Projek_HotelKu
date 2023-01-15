package com.hotelku

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_hal_daftar_hotel.*

class HalDafHo : AppCompatActivity() {
    //Deklarasi variabel
    private var layoutManager: RecyclerView.LayoutManager?=null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hal_daftar_hotel)

        //Menentukan LayoutManager untuk RecyclerView
        layoutManager = LinearLayoutManager(this)
        recycle_view_daftarhotel.layoutManager = layoutManager

        //Link kan RecyclerView dengan class Adapter
        adapter = RecyclerAdapter()
        recycle_view_daftarhotel.adapter = adapter
    }

    fun kembaliKeHalamanUtama(view: View?){
        val i = Intent(applicationContext, MainActivity::class.java)
        startActivity(i)
    }

}