package com.dicoding.budayakalbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class HasilKuis : AppCompatActivity() {

    private lateinit var hasil: TextView
    private lateinit var nilai: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_kuis)

        hasil = findViewById(R.id.hasil)
        nilai = findViewById(R.id.nilai)

        hasil.setText("Jawaban Benar: ${KuisActivity.benar}\nJawaban Salah: ${KuisActivity.salah}")
        nilai.setText("${KuisActivity.hasil}")
    }

    fun ulangi(view: View) {
        finish()
        val a: Intent = Intent(this, KuisActivity::class.java)
        startActivity(a)
    }

    fun kembali(view: View) {
        finish()
        val a: Intent = Intent(this, MainActivity::class.java)
        startActivity(a)
    }
}