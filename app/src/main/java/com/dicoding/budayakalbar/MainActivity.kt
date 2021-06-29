package com.dicoding.budayakalbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cardSuku: CardView = findViewById(R.id.cv_suku)
        val cardKuliner: CardView = findViewById(R.id.cv_kuliner)
        val cardLagu: CardView = findViewById(R.id.cv_lagu)
        val cardKuis: CardView = findViewById(R.id.cv_kuis)

        cardSuku.setOnClickListener(this)
        cardKuliner.setOnClickListener(this)
        cardLagu.setOnClickListener(this)
        cardKuis.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.cv_suku -> {
                val moveIntent = Intent(this@MainActivity, SukuActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.cv_kuliner -> {
                val moveIntent = Intent(this@MainActivity, KulinerActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.cv_lagu -> {
                val moveIntent = Intent(this@MainActivity, LaguActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.cv_kuis -> {
                val moveIntent = Intent(this@MainActivity, KuisActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}