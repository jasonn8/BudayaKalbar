package com.dicoding.budayakalbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class HasilKuis : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil_kuis)

        val hasil: TextView = findViewById(R.id.hasil)
        val nilai: TextView = findViewById(R.id.nilai)

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