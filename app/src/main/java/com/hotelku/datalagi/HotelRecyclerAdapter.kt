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
import com.hotelku.HalamanInformasiHotel
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

        var foto_hotel: ImageView = binding.daftarGambarhotel
        var nama_hotel: TextView = binding.daftarNamahotel
        var rating_hotel: TextView = binding.daftarRatinghotel
        var alamat_hotel: TextView = binding.daftarAlamathotel
        var klik: RelativeLayout = binding.layoutDaftarhotel

        fun bind(DataHotel: DataHotel){
            nama_hotel.setText(DataHotel.nama_hotel)
            rating_hotel.setText(DataHotel.rating_hotel)
            alamat_hotel.setText(DataHotel.alamat_hotel)

            val requestOp = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOp)
                .load(DataHotel.foto_hotel)
                .into(foto_hotel)
        }

        fun kalau_diklik(get: DataHotel){
            Toast.makeText(itemView.context, "Kamu memilih : ${get.nama_hotel}",
                Toast.LENGTH_SHORT)
                .show()

            val intent = Intent(itemView.context, HalamanInformasiHotel::class.java)

            itemView.context.startActivity(intent)
        }

    }
}