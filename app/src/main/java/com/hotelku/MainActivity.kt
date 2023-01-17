package com.hotelku

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.hotelku.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    lateinit var toogle: ActionBarDrawerToggle
    lateinit var DaftarHotelFragment: HalDafHo
    lateinit var InfoPemesananFragment: HalPemHo

    lateinit var MainContent: MainContent

    lateinit var dafho : TextView

    private var linearLayout1: LinearLayout? = null
    private val menukabkota = arrayOf(
        "BENGKALIS",
        "INHIL",
        "INHU",
        "KAMPAR",
        "SMERANTI",
        "KUANSING",
        "PELELAWAN",
        "ROHIL",
        "SIAK",
        "DUMAI",
        "PEKANBARU"
    )
    private val gambarkabkota = intArrayOf(
        R.drawable.kab_bengkalis,
        R.drawable.kab_inhil,
        R.drawable.kab_inhu,
        R.drawable.kab_kampar,
        R.drawable.kab_kep_meranti,
        R.drawable.kab_kuansing,
        R.drawable.kab_pelelawan,
        R.drawable.kab_rohil,
        R.drawable.kab_rohul,
        R.drawable.kab_siak,
        R.drawable.kota_dumai,
        R.drawable.kota_pekanbaru
    )

    //rekom hotel
    private var linearLayout2: LinearLayout? = null
    private val rekomhotel = arrayOf(
        "Grand Central Hotel Pekanbaru"
    )

    private val rekombintang = arrayOf(
        "Bintang 5"
    )

    private val rekomalamat = arrayOf(
        "Jalan Jendral Sudirman No 1 Pekanbaru"
    )

    private val rekomfoto = intArrayOf(
        R.drawable.grandhotelpku
    )

    //rekom hotel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toogle = ActionBarDrawerToggle(this, binding.drawerLayout,R.string.open,R.string.close)
        binding.drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener(this)


        linearLayout1 = findViewById(R.id.linear1)
        val layoutInflater1 = LayoutInflater.from(this)

        for (i in menukabkota.indices) {
            val view: View = layoutInflater1.inflate(R.layout.layout_kabkota, linearLayout1, false)
            val imageView = view.findViewById<ImageView>(R.id.iv)
            imageView.setImageResource(gambarkabkota[i])
            val tv = view.findViewById<TextView>(R.id.tv)
            tv.text = menukabkota[i]
            linearLayout1?.addView(view)
        }

        linearLayout2 = findViewById(R.id.linear2)
        val layoutInflater2 = LayoutInflater.from(this)
        for (i in rekomhotel.indices) {
            val view1: View = layoutInflater2.inflate(R.layout.layout_rekom_hotel, linearLayout2, false)
            val imageView1 = view1.findViewById<ImageView>(R.id.daftar_gambarhotel)
            imageView1.setImageResource(rekomfoto[i])
            val nama = view1.findViewById<TextView>(R.id.daftar_namahotel)
            nama.text = rekomhotel[i]
            val bintang = view1.findViewById<TextView>(R.id.daftar_ratinghotel)
            bintang.text = rekombintang[i]
            val alamat = view1.findViewById<TextView>(R.id.daftar_alamathotel)
            alamat.text = rekomalamat[i]
            linearLayout2?.addView(view1)
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.text_daftarhotel -> {

                    val intent = Intent(this,DafahoTry::class.java)
                    startActivity(intent)

            }
            R.id.text_infopemesanan -> {

                val intent = Intent(this,HalInfoPem::class.java)
                startActivity(intent)

            }
            R.id.text_riwayatpemesanan -> {

                val intent = Intent(this,HalRiwPem::class.java)
                startActivity(intent)

            }
            R.id.text_login -> {
                val intent = Intent(this,Login::class.java)
                startActivity(intent)
            }
        }
        binding.drawerLayout.closeDrawers()
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toogle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun init(){
        dafho = findViewById(R.id.text_daftarhotel)
    }

}


