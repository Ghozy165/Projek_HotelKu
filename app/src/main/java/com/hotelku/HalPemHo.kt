package com.hotelku

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hotelku.databinding.ActivityKamarBinding
import com.hotelku.databinding.ActivityPemesananHotelBinding

class HalPemHo : AppCompatActivity() {

    private lateinit var bindingpemesananhotel: ActivityPemesananHotelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingpemesananhotel = ActivityPemesananHotelBinding.inflate(layoutInflater)
        val viewpemesananhotel = bindingpemesananhotel.root
        setContentView(viewpemesananhotel)

        if (intent.hasExtra("jenis_kamarnya")){
            val jenis_kamar: String = this.intent.getStringExtra("jenis_kamarnya").toString()
            val id_kamar: String = this.intent.getStringExtra("id_kamarnya").toString()
            val jenis_kasur: String = this.intent.getStringExtra("jenis_kasurnya").toString()
            val fasilitas: String = this.intent.getStringExtra("fasilitasnya").toString()
            val foto_kamar: String = this.intent.getStringExtra("foto_kamarnya").toString()
            val harga: String = this.intent.getStringExtra("harganya").toString()
            setInfoKamar(id_kamar, jenis_kamar, jenis_kasur, fasilitas, foto_kamar, harga)
        }

    }

    fun setInfoKamar(
        id_kamar : String,
        jenis_kamar : String,
        jenis_kasur : String,
        fasilitas : String,
        foto_kamar : String,
        harga : String
    ){
        bindingpemesananhotel.pemesananJeniskamar.text = jenis_kamar
        bindingpemesananhotel.pemesananJumlahkasur.text = jenis_kasur
        bindingpemesananhotel.pemesananFasilitas2.text = fasilitas
    }

}