package com.hotelku

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hotelku.databinding.ActivityInformasihotelBinding

class InformasiHotel : AppCompatActivity() {
    private lateinit var binding: ActivityInformasihotelBinding

    private var linearLayout : LinearLayout? = null
    private var gambar = intArrayOf(
        R.drawable.grandhotelpku,
        R.drawable.deluxedoublebed,
        R.drawable.deluxetwin
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformasihotelBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (intent.hasExtra("namanya")){
            val nama_hotel: String = this.intent.getStringExtra("namanya").toString()
            val id_hotel: String = this.intent.getStringExtra("idnya").toString()
            val alamat_hotel: String = this.intent.getStringExtra("alamatnya").toString()
            val no_telepon: String = this.intent.getStringExtra("no_telpnya").toString()
            val rating_hotel: String = this.intent.getStringExtra("ratingnya").toString()
            val foto_hotel: String = this.intent.getStringExtra("fotonya").toString()
            val bintang_hotel: String = this.intent.getStringExtra("bintangnya").toString()
            setInfoHotel(id_hotel, nama_hotel,alamat_hotel,no_telepon,rating_hotel,foto_hotel,bintang_hotel)
        }

        linearLayout = findViewById(R.id.img_fotohotel)
        val layoutInflater = LayoutInflater.from(this)

        for (i in gambar.indices){
            val view: View = layoutInflater.inflate(R.layout.layout_gambarinformasihotel,linearLayout,false)
            val imageView = view.findViewById<ImageView>(R.id.iv)
            imageView.setImageResource(gambar[i])
            linearLayout?.addView(view)
        }


    }

    fun setInfoHotel(
        id_hotel : String,
        nama_hotel : String,
        alamat_hotel : String,
        no_telepon : String,
        rating_hotel : String,
        foto_hotel : String,
        bintang_hotel : String
    ){
        binding.txtNamahotel1.text = nama_hotel
        binding.txtAlamathotel.text = alamat_hotel
    }

    fun kembaliKeHalamanDaftarHotel(view: View?){
        val i = Intent(applicationContext, DafahoTry::class.java)
        startActivity(i)
    }

    fun KeHalamanPesanKamar(view: View?){
        val i = Intent(applicationContext, MainActivity::class.java)
        startActivity(i)
    }

}