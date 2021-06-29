package com.dicoding.budayakalbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailKulinerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_kuliner)


        val heading: TextView = findViewById(R.id.heading)
        val detail: TextView = findViewById(R.id.detail)
        val image: ImageView = findViewById(R.id.image_heading)

        val bundle: Bundle? = intent.extras
        val bHeading = bundle!!.getString("heading")
        val bDetail = bundle.getString("detail")
        val bImage = bundle.getInt("imageId")

        heading.text = bHeading
        detail.text = bDetail
        image.setImageResource(bImage)

    }
}