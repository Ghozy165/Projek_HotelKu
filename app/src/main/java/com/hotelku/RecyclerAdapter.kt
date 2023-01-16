package com.hotelku

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    private val rekomhotel = arrayOf(
        "Grand Central Hotel Pekanbaru",
        "Hotel Pangeran Pekanbaru"
    )

    private val rekombintang = arrayOf(
        "Bintang 5",
        "Bintang 4"
    )

    private val rekomalamat = arrayOf(
        "Jalan Jendral Sudirman No 1 Pekanbaru",
        "Jalan Jend Sudirman No. 371-373, Pusat Kota Pekanbaru"
    )

    private val rekomfoto = intArrayOf(
        R.drawable.grandhotelpku,
        R.drawable.superiordoublezuri
    )

    //ViewHolder class
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemName: TextView
        var itemalamat: TextView
        var itembintang: TextView
        init{
            itemImage = itemView.findViewById(R.id.daftar_gambarhotel)
            itemName = itemView.findViewById(R.id.daftar_namahotel)
            itemalamat = itemView.findViewById(R.id.daftar_alamathotel)
            itembintang = itemView.findViewById(R.id.daftar_ratinghotel)

            itemView.setOnClickListener { v: View ->
                var position: Int = getAdapterPosition()
                Snackbar.make(v, "Click on item ${rekomhotel[position]}",
                    Snackbar.LENGTH_LONG).setAction("Action",null).show()
            }
        }

    }

    //onCreateViewHolder()
    override fun onCreateViewHolder(ViewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(ViewGroup.context)
            .inflate(R.layout.layout_daftar_hotel, ViewGroup, false)
        return ViewHolder(v)
    }
    //onBindViewHolder()
    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemName.text = rekomhotel[i]
        viewHolder.itemalamat.text = rekomalamat[i]
        viewHolder.itemImage.setImageResource(rekomfoto[i])
    }
    //getItemCount()
    override fun getItemCount(): Int {
        return rekomhotel.size
    }
}