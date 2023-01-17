package com.hotelku

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import com.hotelku.databinding.ActivityPemesananHotelBinding
import kotlinx.android.synthetic.main.activity_pemesanan_hotel.*


class HalPemHo : AppCompatActivity() {

    private lateinit var bindingpemesananhotel: ActivityPemesananHotelBinding

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingpemesananhotel = ActivityPemesananHotelBinding.inflate(layoutInflater)
        val viewpemesananhotel = bindingpemesananhotel.root
        setContentView(viewpemesananhotel)

        if (intent.hasExtra("jenis_kamarnya")) {
            jenis_kamar = this.intent.getStringExtra("jenis_kamarnya").toString()
            id_kamar = this.intent.getStringExtra("id_kamarnya").toString()
            jenis_kasur = this.intent.getStringExtra("jenis_kasurnya").toString()
            fasilitas = this.intent.getStringExtra("fasilitasnya").toString()
            foto_kamar = this.intent.getStringExtra("foto_kamarnya").toString()
            harga = this.intent.getStringExtra("harganya").toString()
            setInfoKamar(
                id_kamar!!,
                jenis_kamar!!,
                jenis_kasur!!,
                fasilitas!!,
                foto_kamar!!,
                harga!!
            )
        }

        nama_pemesan = bindingpemesananhotel.edtPemesananNama.toString()
        hp = bindingpemesananhotel.edtPemesananTelepon.toString()
        email = bindingpemesananhotel.edtPemesananEmail.toString()
        cekin = bindingpemesananhotel.edtPemesananCheckin.toString()
        cekout = bindingpemesananhotel.edtPemesananCheckout.toString()

    }

    fun setInfoKamar(
        id_kamar: String,
        jenis_kamar: String,
        jenis_kasur: String,
        fasilitas: String,
        foto_kamar: String,
        harga: String
    ) {
        bindingpemesananhotel.pemesananJeniskamar.text = jenis_kamar
        bindingpemesananhotel.pemesananJumlahkasur.text = jenis_kasur
        bindingpemesananhotel.pemesananFasilitas2.text = fasilitas
    }

    fun KeBayarPemesanan(v: View?) {
        simpanDataPemesanan()
    }

    private fun simpanDataPemesanan() {
            try {
                nama_pemesan = nama_pemesan.toString()
                hp = hp.toString()
                email = email.toString()
                cekin = cekin.toString()
                cekout = cekout.toString()

                if (
                    nama_pemesan != null && nama_pemesan !== "" ||
                    hp != null && hp !== "" ||
                    email != null && email !== "" ||
                    cekin != null && cekin !== "" ||
                    cekout != null && cekout !== ""
                ) {
                    val i = Intent(this@HalPemHo, HalBayarHo::class.java)
                    intent.apply {
                        i.putExtra(KEY_NAME, nama_pemesan)
                        i.putExtra(KEY_NAME, hp)
                        i.putExtra(KEY_NAME, email)
                        i.putExtra(KEY_NAME, cekin)
                        i.putExtra(KEY_NAME, cekout)

                        i.putExtra(KEY_NAME, jenis_kamar)
                        i.putExtra(KEY_NAME, id_kamar)
                        i.putExtra(KEY_NAME, jenis_kasur)
                        i.putExtra(KEY_NAME, fasilitas)
                        i.putExtra(KEY_NAME, foto_kamar)
                        i.putExtra(KEY_NAME, harga)
                    }
                    startActivity(i)
                } else {
                    Toast.makeText(application, "YOU NEED TO FILL ALL", Toast.LENGTH_SHORT)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(application, "ERROR, TRY AGAIN !", Toast.LENGTH_SHORT)
            }
        }
}