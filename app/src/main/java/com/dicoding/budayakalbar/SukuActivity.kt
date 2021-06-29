package com.dicoding.budayakalbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SukuActivity : AppCompatActivity() {


    private lateinit var sukuRecyclerView: RecyclerView
    private lateinit var sukuArrayList: ArrayList<Data>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var detail: Array<String>
    lateinit var pakaian: Array<String>
    lateinit var imagePakaian: Array<Int>
    lateinit var detailPakaian: Array<String>
    lateinit var senjata: Array<String>
    lateinit var imageSenjata: Array<Int>
    lateinit var detailSenjata: Array<String>
    lateinit var rumah: Array<String>
    lateinit var imageRumah: Array<Int>
    lateinit var detailRumah: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_suku)

        supportActionBar?.title = "Suku"

        imageId = arrayOf(
            R.drawable.dayak,
            R.drawable.melayu,
            R.drawable.jawa,
            R.drawable.tionghoa,
            R.drawable.madura,
            R.drawable.bugis,
        )

        heading = arrayOf(
            getString(R.string.dayak),
            getString(R.string.melayu),
            getString(R.string.jawa),
            getString(R.string.tionghoa),
            getString(R.string.madura),
            getString(R.string.bugis)
        )

        detail = arrayOf(
            getString(R.string.detail_dayak),
            getString(R.string.detail_melayu),
            getString(R.string.detail_jawa),
            getString(R.string.detail_tionghoa),
            getString(R.string.detail_madura),
            getString(R.string.detail_bugis)
        )

        pakaian = arrayOf(
            getString(R.string.pakaian_tradisional),
            getString(R.string.pakaian_tradisional),
            getString(R.string.pakaian_tradisional),
            getString(R.string.pakaian_tradisional),
            getString(R.string.pakaian_tradisional),
            getString(R.string.pakaian_tradisional)
        )

        imagePakaian = arrayOf(
            R.drawable.pakaian_tradisional_dayak,
            R.drawable.pakaian_tradisional_melayu,
            R.drawable.pakaian_tradisional_jawa,
            R.drawable.pakaian_tradisional_tionghoa,
            R.drawable.madura,
            R.drawable.pakaian_tradisional_bugis
        )

        detailPakaian = arrayOf(
            getString(R.string.detail_pakaian_tradisional_dayak),
            getString(R.string.detail_pakaian_tradisional_melayu),
            getString(R.string.detail_pakaian_tradisional_jawa),
            getString(R.string.detail_pakaian_tradisional_tionghoa),
            getString(R.string.detail_pakaian_tradisional_madura),
            getString(R.string.detail_pakaian_tradisional_bugis)
        )

        senjata = arrayOf(
            getString(R.string.senjata_tradisional),
            getString(R.string.senjata_tradisional),
            getString(R.string.senjata_tradisional),
            getString(R.string.perayaan_tionghoa),
            getString(R.string.senjata_tradisional),
            getString(R.string.senjata_tradisional)
        )

        imageSenjata = arrayOf(
            R.drawable.senjata_tradisional_dayak,
            R.drawable.senjata_tradisional_melayu,
            R.drawable.senjata_tradisional_jawa,
            R.drawable.perayaan_tionghoa,
            R.drawable.senjata_tradisional_madura,
            R.drawable.senjata_tradisional_bugis
        )

        detailSenjata = arrayOf(
            getString(R.string.detail_senjata_tradisional_dayak),
            getString(R.string.detail_senjata_tradisional_melayu),
            getString(R.string.detail_senjata_tradisional_jawa),
            getString(R.string.detail_perayaan_tionghoa),
            getString(R.string.detail_senjata_tradisional_madura),
            getString(R.string.detail_senjata_tradisional_bugis)
        )

        rumah = arrayOf(
            getString(R.string.rumah_adat),
            getString(R.string.rumah_adat),
            getString(R.string.rumah_adat),
            getString(R.string.bangunan_tionghoa),
            getString(R.string.rumah_budaya),
            getString(R.string.rumah_adat)
        )

        imageRumah = arrayOf(
            R.drawable.rumah_adat_dayak,
            R.drawable.rumah_adat_melayu,
            R.drawable.rumah_adat_jawa,
            R.drawable.bangunan_tionghoa,
            R.drawable.rumah_adat_madura,
            R.drawable.rumah_adat_bugis
        )

        detailRumah = arrayOf(
            getString(R.string.detail_rumah_adat_dayak),
            getString(R.string.detail_rumah_adat_melayu),
            getString(R.string.detail_rumah_adat_jawa),
            getString(R.string.detail_bangunan_tionghoa),
            getString(R.string.detail_rumah_budaya),
            getString(R.string.detail_rumah_adat_bugis)
        )

        sukuRecyclerView = findViewById(R.id.sukuRecyclerView)
        sukuRecyclerView.layoutManager = LinearLayoutManager(this)
        sukuRecyclerView.setHasFixedSize(true)

        sukuArrayList = arrayListOf<Data>()
        getUserData()
    }

    private fun getUserData() {
        for (i in imageId.indices) {
            val suku = Data(imageId[i],heading[i])
            sukuArrayList.add(suku)
        }

        var adapter = MyAdapter(sukuArrayList)
        sukuRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@SukuActivity, DetailSukuActivity::class.java)
                intent.putExtra("heading", sukuArrayList[position].heading)
                intent.putExtra("imageId", sukuArrayList[position].titleImage)
                intent.putExtra("detail", detail[position])
                intent.putExtra("pakaian", pakaian[position])
                intent.putExtra("imagePakaian", imagePakaian[position])
                intent.putExtra("detailPakaian", detailPakaian[position])
                intent.putExtra("senjata", senjata[position])
                intent.putExtra("imageSenjata", imageSenjata[position])
                intent.putExtra("detailSenjata", detailSenjata[position])
                intent.putExtra("rumah", rumah[position])
                intent.putExtra("imageRumah", imageRumah[position])
                intent.putExtra("detailRumah", detailRumah[position])
                startActivity(intent)
            }
        })
    }
}