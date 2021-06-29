package com.dicoding.budayakalbar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class KulinerActivity : AppCompatActivity() {

    private lateinit var kulinerRecyclerView: RecyclerView
    private lateinit var kulinerArrayList: ArrayList<Data>
    lateinit var imageId: Array<Int>
    lateinit var heading: Array<String>
    lateinit var detail: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kuliner)

        supportActionBar?.title = "Kuliner"

        imageId = arrayOf(
            R.drawable.bubur_pedas,
            R.drawable.kuliner,
            R.drawable.che_hun_tiau,
            R.drawable.kiam_ko_kwe,
            R.drawable.kue_kantong_semar,
            R.drawable.kwetiau,
            R.drawable.lek_tau_swan,
            R.drawable.pengkang,
            R.drawable.sotong_pangkong
        )

        heading = arrayOf(
            getString(R.string.bubur_pedas),
            getString(R.string.chai_kwe),
            getString(R.string.che_hun_tiau),
            getString(R.string.kiam_ko_kwe),
            getString(R.string.kue_kantong_semar),
            getString(R.string.kwetiau),
            getString(R.string.lek_tau_swan),
            getString(R.string.pengkang),
            getString(R.string.sotong_pangkong)
        )

        detail = arrayOf(
            getString(R.string.detail_bubur_pedas),
            getString(R.string.detail_chai_kwe),
            getString(R.string.detail_che_hun_tiau),
            getString(R.string.detail_kiam_ko_kwe),
            getString(R.string.detail_kue_kantong_semar),
            getString(R.string.detail_kwetiau),
            getString(R.string.detail_lek_tau_swan),
            getString(R.string.detail_pengkang),
            getString(R.string.detail_sotong_pangkong)
        )

        kulinerRecyclerView = findViewById(R.id.kulinerRecyclerView)
        kulinerRecyclerView.layoutManager = LinearLayoutManager(this)
        kulinerRecyclerView.setHasFixedSize(true)

        kulinerArrayList = arrayListOf<Data>()
        getUserData()
    }

    private fun getUserData() {
        for (i in imageId.indices) {
            val kuliner = Data(imageId[i], heading[i])
            kulinerArrayList.add(kuliner)
        }

        var adapter = MyAdapter(kulinerArrayList)
        kulinerRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : MyAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {
                val intent = Intent(this@KulinerActivity, DetailKulinerActivity::class.java)
                intent.putExtra("heading",kulinerArrayList[position].heading)
                intent.putExtra("imageId",kulinerArrayList[position].titleImage)
                intent.putExtra("detail",detail[position])
                startActivity(intent)
            }
        })
    }
}