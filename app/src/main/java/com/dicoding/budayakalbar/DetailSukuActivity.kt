package com.dicoding.budayakalbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailSukuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_suku)

        val heading: TextView = findViewById(R.id.heading)
        val detail: TextView = findViewById(R.id.detail)
        val image: ImageView = findViewById(R.id.image_heading)
        val pakaianAdat: TextView = findViewById(R.id.pakaian_adat)
        val detailPakaianAdat: TextView = findViewById(R.id.detail_pakaian_adat)
        val imagePakaian: ImageView = findViewById(R.id.image_pakaian)
        val senjata: TextView = findViewById(R.id.senjata)
        val detailSenjata: TextView = findViewById(R.id.detail_senjata)
        val imageSenjata: ImageView = findViewById(R.id.image_senjata_tradisional)
        val rumahAdat: TextView = findViewById(R.id.rumah_adat)
        val detailRumahAdat: TextView = findViewById(R.id.detail_rumah_adat)
        val imageRumahAdat: ImageView = findViewById(R.id.image_rumah_adat)

        val bundle: Bundle? = intent.extras
        val bHeading = bundle!!.getString("heading")
        val bDetail = bundle.getString("detail")
        val bImage = bundle.getInt("imageId")
        val bPakaianAdat = bundle.getString("pakaian")
        val bDetailPakaianAdat = bundle.getString("detailPakaian")
        val bImagePakaian = bundle.getInt("imagePakaian")
        val bSenjata = bundle.getString("senjata")
        val bDetailSenjata = bundle.getString("detailSenjata")
        val bimageSenjata = bundle.getInt("imageSenjata")
        val bRumahAdat = bundle.getString("rumah")
        val bDetailRumahAdat = bundle.getString("detailRumah")
        val bImageRumahAdat = bundle.getInt("imageRumah")

        heading.text = bHeading
        detail.text = bDetail
        image.setImageResource(bImage)
        pakaianAdat.text = bPakaianAdat
        detailPakaianAdat.text = bDetailPakaianAdat
        imagePakaian.setImageResource(bImagePakaian)
        senjata.text = bSenjata
        detailSenjata.text = bDetailSenjata
        imageSenjata.setImageResource(bimageSenjata)
        rumahAdat.text = bRumahAdat
        detailRumahAdat.text = bDetailRumahAdat
        imageRumahAdat.setImageResource(bImageRumahAdat)


    }
}