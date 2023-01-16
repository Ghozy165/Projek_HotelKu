package com.hotelku.datalagi

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.hotelku.HalPemHo
import com.hotelku.databinding.LayoutDaftarkamarBinding

class KamarRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var itemsKamar: List<DataKamar> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KamarViewHolder {
        val bindingdaftarkamar = LayoutDaftarkamarBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return KamarViewHolder(bindingdaftarkamar)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder){
            is KamarViewHolder -> {
                holder.bind(itemsKamar.get(position))
                holder.klik.setOnClickListener{
                    holder.kalau_diklik_daftarkamar(itemsKamar.get(position))
                }
            }
        }
    }

    fun submitList(listKamar: List<DataKamar>){
        itemsKamar = listKamar
    }

    override fun getItemCount(): Int {
        return itemsKamar.size
    }

    class KamarViewHolder constructor(val binding: LayoutDaftarkamarBinding):
        RecyclerView.ViewHolder(binding.root){

        var jenis_kamar: TextView = binding.txtJeniskamar
        var jenis_kasur: TextView = binding.txtKasur
        var fasilitas: TextView = binding.txtFasilitas1
        var foto_kamar: ImageView = binding.imgFotokamar
        var harga: TextView = binding.txtHarga1
        var klik: Button = binding.btnPesankamar

        fun bind(DataKamar: DataKamar){
            jenis_kamar.setText(DataKamar.jenis_kamar)
            jenis_kasur.setText(DataKamar.jenis_kasur)
            fasilitas.setText(DataKamar.fasilitas)
            //foto_kamar.setText(DataKamar.foto_kamar)
            harga.setText(DataKamar.harga)
        }

        fun kalau_diklik_daftarkamar(get: DataKamar){
            Toast.makeText(itemView.context, "Kamu memilih : ${get.jenis_kamar}",
                Toast.LENGTH_SHORT)
                .show()

            val intent = Intent(itemView.context, HalPemHo::class.java)
            intent.putExtra("jenis_kamarnya", get.jenis_kamar)
            intent.putExtra("id_kamarnya", get.id_kamar)
            intent.putExtra("jenis_kasurnya", get.jenis_kasur)
            intent.putExtra("fasilitasnya", get.fasilitas)
            intent.putExtra("harganya", get.harga)
            itemView.context.startActivity(intent)
        }

    }
}