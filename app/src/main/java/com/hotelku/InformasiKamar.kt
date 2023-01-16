package com.hotelku

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hotelku.databinding.ActivityHalDaftarHotelBinding
import com.hotelku.databinding.ActivityInformasihotelBinding
import com.hotelku.databinding.ActivityKamarBinding
import com.hotelku.databinding.LayoutDaftarkamarBinding
import com.hotelku.datalagi.*

class InformasiKamar : AppCompatActivity() {

    private lateinit var KamarRecyclerAdapter: KamarRecyclerAdapter
    private lateinit var bindingdaftarkamar: ActivityKamarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingdaftarkamar = ActivityKamarBinding.inflate(layoutInflater)
        setContentView(bindingdaftarkamar.root)
        initRecyclerViewKamar()
        tambahDataSetKamar()
    }

    private fun tambahDataSetKamar(){
        val data = IsiKamar.setDataKamar()
        KamarRecyclerAdapter.submitList(data)
    }

    private fun initRecyclerViewKamar(){
        bindingdaftarkamar.recyclerviewInformasikamar.apply{
            layoutManager = LinearLayoutManager(this@InformasiKamar)
            KamarRecyclerAdapter = KamarRecyclerAdapter()
            adapter = KamarRecyclerAdapter
        }
    }

    fun kembaliKeHalamanUtama(view: View?){
        val i = Intent(applicationContext, InformasiHotel::class.java)
        startActivity(i)
    }
}