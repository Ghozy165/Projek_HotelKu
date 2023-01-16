package com.hotelku

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hotelku.databinding.ActivityPemesananHotelBinding
import com.hotelku.databinding.LayoutDaftarkamarBinding
import com.hotelku.datalagi.DataKamar

class KamarRecycleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var items :List<DataKamar> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KamarViewHolder{
        TODO("Not yet implemented")
        val binding = LayoutDaftarkamarBinding.inflate(LayoutInflater.from(parent.context),
        parent,false)
        return KamarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
        when(holder){
            is KamarViewHolder -> {
                holder.bind(items.get(position))
                holder.klik.setOnClickListener{
                    holder.kalau_diklik(items.get(position))
                }
            }
        }
    }
    fun submitList(dataKamar: List<DataKamar>){
        items = dataKamar
    }

    override fun getItemCount(): Int {
        return items.size
    }
    class KamarViewHolder constructor(val binding: LayoutDaftarkamarBinding) :
            RecyclerView.ViewHolder(binding.root){
                val foto_kamar: ImageView = binding.imgFotokamar
                val jenis_kamar: TextView = binding.txtJeniskamar
                val jenis_kasur: TextView = binding.txtKasur
                val fasilitas: TextView = binding.txtFasilitas1

                fun bind(dataKamar: List<DataKamar>){
                    jenis_kamar.setText(dataKamar.jenis_kamar)
                    jenis_kasur.setText(dataKamar.jenis_kasur)
                }
            }
}