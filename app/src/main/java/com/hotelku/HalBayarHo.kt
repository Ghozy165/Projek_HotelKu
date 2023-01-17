package com.hotelku

import android.R
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.hotelku.databinding.ActivityPembayaranBinding


class HalBayarHo : AppCompatActivity()  {
    private lateinit var bindingpembayaran: ActivityPembayaranBinding

    private val KEY_NAME = "BAYAR"

    var jenis_kamar: String? = null
    var id_kamar: String? = null
    var jenis_kasur: String? = null
    var fasilitas: String? = null
    var foto_kamar: String? = null
    var harga: String? = null

    var nama_pemesan: String? = null
    var hp: String? = null
    var email: String? = null
    var cekin: String? = null
    var cekout: String? = null

    var txt_idpemesanan: TextView? = null
    var txt_namapemesanan: TextView? = null
    var txt_teleponpemesanan: TextView? = null
    var txt_emailpemesanan: TextView? = null
    var txt_jeniskamarpemesanan: TextView? = null
    var txt_cekinpemesanan: TextView? = null
    var txt_cekoutpemesanan: TextView? = null
    var txt_biayapemesanan: TextView? = null
    var txt_norekeningpemesanan: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingpembayaran = ActivityPembayaranBinding.inflate(layoutInflater)
        val viewpembayaranhotel = bindingpembayaran.root
        setContentView(viewpembayaranhotel)

        //val extras = intent.extras

        //nama_pemesan = extras!!.getString(KEY_NAME)
        //txt_idpemesanan!!.text =  nama_pemesan.toString()

        //bindingpembayaran.pembayaranId1.text = ""
        //bindingpembayaran.pembayaranNama1.text = nama_pemesan

    }
}