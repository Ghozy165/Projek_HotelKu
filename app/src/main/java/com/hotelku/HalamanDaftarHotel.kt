package com.hotelku

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hotelku.databinding.FragmentHalamanDaftarHotelBinding
import com.hotelku.datalagi.DekorasiSpasiGambar
import com.hotelku.datalagi.HotelRecyclerAdapter
import com.hotelku.datalagi.IsiHotel

class HalamanDaftarHotel : Fragment(){

    private lateinit var HotelAdapter: HotelRecyclerAdapter
    private lateinit var binding: FragmentHalamanDaftarHotelBinding

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_halaman_daftar_hotel,
            container, false)

        initRecyclerView()
        tambahDataSet()

    }

    private fun tambahDataSet(){
        val data = IsiHotel.buatSetData()
        HotelAdapter.submitList(data)
    }

    private fun initRecyclerView(){
        binding.recycleViewDaftarhotel.apply{

            val spacingAtas = DekorasiSpasiGambar(20)
            addItemDecoration(spacingAtas)
            HotelAdapter = HotelRecyclerAdapter()
            adapter = HotelAdapter
        }
    }

}