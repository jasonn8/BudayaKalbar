package com.dicoding.budayakalbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class KuisActivity : AppCompatActivity() {

    companion object {
        var hasil = 0
        var benar = 0
        var salah = 0
    }

    private lateinit var kuis: TextView
    private lateinit var rg: RadioGroup
    private lateinit var pilihanA: RadioButton
    private lateinit var pilihanB: RadioButton
    private lateinit var pilihanC: RadioButton
    private lateinit var pilihanD: RadioButton
    private var nomor = 0


    val soal: Array<String> = arrayOf(
        "Mandau merupakan senjata tradisional yang berasal dari suku...",
        "Pakaian tradisional suku Madura bernama...",
        "Suku yang teridentifikasi memiliki 13 kerajaan adalah...",
        "Cheongsam merupakan pakaian tradisional dari...",
        "Lagu Jubata merupakan lagu yang berasal dari suku Dayak yang memiliki arti...",
        "Berikut ini merupakan kuliner khas Kalimantan Barat kecuali...",
        "'Takadang jantu barang dah latih'. Penggalan lirik tersebut berasal dari lagu...",
        "Rumah Adat Saoraja merupakan rumah adat yang berasal dari suku..."
    )

    val pilihanJawaban = arrayOf(
        "Jawa", "Dayak", "Melayu", "Bugis",
        "Batik", "Teluk Belanga", "King Baba", "Pesa'an",
        "Jawa", "Dayak", "Melayu", "Madura",
        "Tionghoa", "Dayak", "Melayu", "Bugis",
        "Tanah", "Tuhan", "Sungai", "Keselamatan",
        "Kwetiau", "Pengkang", "Rendang", "Chai Kwe",
        "Tanah Parenean", "Jubata", "Cik Cik Periuk", "Sungai Kapuas",
        "Dayak", "Tionghoa", "Melayu", "Bugis"
    )

    val jawabanBenar = arrayOf(
        "Dayak",
        "Pesa'an",
        "Melayu",
        "Tionghoa",
        "Tuhan",
        "Rendang",
        "Jubata",
        "Bugis"
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kuis)

        supportActionBar?.title = "Kuis"

        kuis = findViewById(R.id.kuis)
        rg = findViewById(R.id.pilihan)
        pilihanA = findViewById(R.id.pilihanA)
        pilihanB = findViewById(R.id.pilihanB)
        pilihanC = findViewById(R.id.pilihanC)
        pilihanD = findViewById(R.id.pilihanD)

        kuis.setText(soal[nomor])
        pilihanA.setText(pilihanJawaban[0])
        pilihanB.setText(pilihanJawaban[1])
        pilihanC.setText(pilihanJawaban[2])
        pilihanD.setText(pilihanJawaban[3])

        rg.check(0)
        benar = 0
        salah = 0


    }

    fun next(view: View) {
        if (pilihanA.isChecked || pilihanB.isChecked || pilihanC.isChecked || pilihanD.isChecked) {
            val jawabanUser: RadioButton = findViewById(rg.checkedRadioButtonId)
            val ambilJawabanUser: String = jawabanUser.text.toString()
            rg.check(0)

            if (ambilJawabanUser.equals(jawabanBenar[nomor])) benar++
            else salah++
            nomor++

            if (nomor < soal.size) {
                kuis.setText(soal[nomor])
                pilihanA.setText(pilihanJawaban[(nomor * 4) + 0])
                pilihanB.setText(pilihanJawaban[(nomor * 4) + 1])
                pilihanC.setText(pilihanJawaban[(nomor * 4) + 2])
                pilihanD.setText(pilihanJawaban[(nomor * 4) + 3])
            } else {
                hasil = benar * 100 / 8
                val selesai = Intent(this, HasilKuis::class.java)
                startActivity(selesai)
            }
        } else {
            Toast.makeText(this, "Belum Dijawab", Toast.LENGTH_SHORT).show()
        }
    }
}