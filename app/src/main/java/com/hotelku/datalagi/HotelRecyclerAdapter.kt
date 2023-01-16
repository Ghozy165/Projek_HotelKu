package com.hotelku.datalagi

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hotelku.InformasiHotel
import com.hotelku.R
import com.hotelku.databinding.LayoutDaftarHotelBinding

class HotelRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items: List<DataHotel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelViewHolder {
        val binding = LayoutDaftarHotelBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return HotelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder){
            is HotelViewHolder -> {
                holder.bind(items.get(position))
                holder.klik.setOnClickListener{
                    holder.kalau_diklik(items.get(position))
                }
            }
        }
    }

    fun submitList(listHotel: List<DataHotel>){
        items = listHotel
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class HotelViewHolder constructor(val binding: LayoutDaftarHotelBinding):
        RecyclerView.ViewHolder(binding.root){


        var nama_hotel: TextView = binding.daftarNamahotel

        var alamat_hotel: TextView = binding.daftarAlamathotel
        var klik: RelativeLayout = binding.layoutDaftarhotel

        fun bind(DataHotel: DataHotel){
            nama_hotel.setText(DataHotel.nama_hotel)

            alamat_hotel.setText(DataHotel.alamat_hotel)

        }

        fun kalau_diklik(get: DataHotel){
            Toast.makeText(itemView.context, "Kamu memilih : ${get.nama_hotel}",
                Toast.LENGTH_SHORT)
                .show()

            val intent = Intent(itemView.context, InformasiHotel::class.java)
            intent.putExtra("namanya", get.nama_hotel)
            intent.putExtra("idnya", get.id_hotel)
            intent.putExtra("alamatnya", get.alamat_hotel)
            intent.putExtra("no_telpnya", get.no_telpon)
            intent.putExtra("ratingnya", get.rating_hotel)
            intent.putExtra("fotonya", get.foto_hotel)
            intent.putExtra("bintangnya", get.bintang_hotel)
            itemView.context.startActivity(intent)
        }

    }
}