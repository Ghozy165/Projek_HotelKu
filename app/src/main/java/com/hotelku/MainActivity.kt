package com.hotelku

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.navigation.NavigationView
import com.hotelku.databinding.ActivityMainBinding
import com.hotelku.databinding.FragmentHalamanDaftarHotelBinding

class MainActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    lateinit var toogle: ActionBarDrawerToggle
    lateinit var DaftarHotelFragment: HalamanDaftarHotel
    lateinit var InfoPemesananFragment: HalamanInfoPemesanan
    lateinit var RiwayatPemesananFragment: HalamanRiwayatPemesanan

    private var linearLayout: LinearLayout? = null
    private val menukabkota = arrayOf(
        "BENGKALIS",
        "INHIL",
        "INHU",
        "KAMPAR",
        "MERANTI",
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toogle = ActionBarDrawerToggle(this, binding.drawerLayout,R.string.open,R.string.close)
        binding.drawerLayout.addDrawerListener(toogle)
        toogle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener(this)


        linearLayout = findViewById(R.id.linear1)
        val layoutInflater = LayoutInflater.from(this)

        for (i in menukabkota.indices) {
            val view: View = layoutInflater.inflate(R.layout.layout_kabkota, linearLayout, false)
            val imageView = view.findViewById<ImageView>(R.id.iv)
            imageView.setImageResource(gambarkabkota[i])
            val tv = view.findViewById<TextView>(R.id.tv)
            tv.text = menukabkota[i]
            linearLayout?.addView(view)
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.text_daftarhotel -> {
                DaftarHotelFragment = HalamanDaftarHotel()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, DaftarHotelFragment)
                    .setTransition(FragmentTransaction. TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext, "Ini Halaman Daftar Hotel", Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.text_infopemesanan -> {
                InfoPemesananFragment = HalamanInfoPemesanan()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, InfoPemesananFragment)
                    .setTransition(FragmentTransaction. TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext, "Ini Halaman Info Pemesanan", Toast.LENGTH_SHORT)
                    .show()
            }
            R.id.text_riwayatpemesanan -> {
                RiwayatPemesananFragment = HalamanRiwayatPemesanan()
                supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame_layout, RiwayatPemesananFragment)
                    .setTransition(FragmentTransaction. TRANSIT_FRAGMENT_OPEN)
                    .commit()
                Toast.makeText(applicationContext, "Ini Halaman Riwayat Pemesanan", Toast.LENGTH_SHORT)
                    .show()
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
}


