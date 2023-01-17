package com.hotelku

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hotelku.databinding.ActivityInforiwayatpemesananBinding
import com.hotelku.databinding.ActivityInformasipemesananBinding
import com.hotelku.databinding.ActivityPembayaranBinding

class HalRiwPem : AppCompatActivity()  {
    private lateinit var binding: ActivityInforiwayatpemesananBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInforiwayatpemesananBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun kembaliKeHalamanUtama(view: View?){
        val i = Intent(applicationContext, MainActivity::class.java)
        startActivity(i)
    }

}