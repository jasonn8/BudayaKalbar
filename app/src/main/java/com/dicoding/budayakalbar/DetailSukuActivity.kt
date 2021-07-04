package com.dicoding.budayakalbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailSukuActivity : AppCompatActivity() {

    private lateinit var heading: TextView
    private lateinit var detail: TextView
    private lateinit var image: ImageView
    private lateinit var pakaianAdat: TextView
    private lateinit var detailPakaianAdat: TextView
    private lateinit var imagePakaian: ImageView
    private lateinit var senjata: TextView
    private lateinit var detailSenjata: TextView
    private lateinit var imageSenjata: ImageView
    private lateinit var rumahAdat: TextView
    private lateinit var detailRumahAdat: TextView
    private lateinit var imageRumahAdat: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_suku)

        heading = findViewById(R.id.heading)
        detail = findViewById(R.id.detail)
        image = findViewById(R.id.image_heading)
        pakaianAdat = findViewById(R.id.pakaian_adat)
        detailPakaianAdat = findViewById(R.id.detail_pakaian_adat)
        imagePakaian = findViewById(R.id.image_pakaian)
        senjata = findViewById(R.id.senjata)
        detailSenjata = findViewById(R.id.detail_senjata)
        imageSenjata = findViewById(R.id.image_senjata_tradisional)
        rumahAdat = findViewById(R.id.rumah_adat)
        detailRumahAdat = findViewById(R.id.detail_rumah_adat)
        imageRumahAdat = findViewById(R.id.image_rumah_adat)

        val bundle: Bundle? = intent.extras
        val bHeading = bundle!!.getString("heading")

        heading.text = bHeading
        detail.text = bundle.getString("detail")
        image.setImageResource(bundle.getInt("imageId"))
        pakaianAdat.text = bundle.getString("pakaian")
        detailPakaianAdat.text = bundle.getString("detailPakaian")
        imagePakaian.setImageResource(bundle.getInt("imagePakaian"))
        senjata.text = bundle.getString("senjata")
        detailSenjata.text = bundle.getString("detailSenjata")
        imageSenjata.setImageResource(bundle.getInt("imageSenjata"))
        rumahAdat.text = bundle.getString("rumah")
        detailRumahAdat.text = bundle.getString("detailRumah")
        imageRumahAdat.setImageResource(bundle.getInt("imageRumah"))


    }
}