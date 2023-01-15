package com.hotelku

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hotelku.databinding.FragmentHalamanDaftarHotelBinding
import com.hotelku.datalagi.DekorasiSpasiGambar
import com.hotelku.datalagi.HotelRecyclerAdapter
import com.hotelku.datalagi.IsiHotel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_halaman_daftar_hotel.*

class HalamanDaftarHotel : Fragment(){

    private lateinit var HotelAdapter: HotelRecyclerAdapter
    private lateinit var binding: FragmentHalamanDaftarHotelBinding

    //Deklarasi variabel
    private var layoutManager: RecyclerView.LayoutManager?=null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>?=null

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_halaman_daftar_hotel,
            container, false)

        //Menentukan LayoutManager untuk RecyclerView

        recycle_view_daftarhotel.layoutManager = layoutManager

        //Link kan RecyclerView dengan class Adapter
        adapter = RecyclerAdapter()
        recycle_view_daftarhotel.adapter = adapter

        }
}