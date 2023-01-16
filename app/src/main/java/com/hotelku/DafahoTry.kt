package com.hotelku

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hotelku.databinding.ActivityHalDaftarHotelBinding
import com.hotelku.datalagi.HotelRecyclerAdapter
import com.hotelku.datalagi.IsiHotel
import kotlinx.android.synthetic.main.activity_hal_daftar_hotel.*

class DafahoTry : AppCompatActivity() {
    private lateinit var HotelRecyclerAdapter: HotelRecyclerAdapter
    private lateinit var binding: ActivityHalDaftarHotelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHalDaftarHotelBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
        tambahDataSet()
    }

    private fun tambahDataSet(){
        val data = IsiHotel.buatSetData()
        HotelRecyclerAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        binding.recycleViewDaftarhotel.apply{
            layoutManager = LinearLayoutManager(this@DafahoTry)
            HotelRecyclerAdapter = HotelRecyclerAdapter()
            adapter = HotelRecyclerAdapter
        }
    }

    fun kembaliKeHalamanUtama(view: View?){
        val i = Intent(applicationContext, MainActivity::class.java)
        startActivity(i)
    }

}