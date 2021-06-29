package com.dicoding.budayakalbar

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView

class LaguActivity : AppCompatActivity() {

    private lateinit var title: TextView
    private lateinit var play: ImageButton
    private lateinit var prev: ImageButton
    lateinit var next: ImageButton
    private lateinit var detail: TextView
    lateinit var mediaPlayer: MediaPlayer
    private var currentIndex: Int = 0
    lateinit var seekBar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lagu)

        supportActionBar?.title = "Lagu"

        title = findViewById(R.id.song_title)
        play = findViewById(R.id.play)
        prev = findViewById(R.id.prev)
        next = findViewById(R.id.next)
        seekBar = findViewById(R.id.seekBar_time)
        detail = findViewById(R.id.detail)

        val songs = ArrayList<Int>()
        songs.add(0,R.raw.cikcik_periuk)
        songs.add(1,R.raw.sungai_kapuas)
        songs.add(2,R.raw.tanah_parenean)
        songs.add(3,R.raw.jubata)

        mediaPlayer = MediaPlayer.create(applicationContext, songs[currentIndex])
        seekBar.progress = 0
        seekBar.max = mediaPlayer.duration

        play.setOnClickListener {
            seekBar.max = mediaPlayer.duration
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                play.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            } else {
                mediaPlayer.start()
                play.setImageResource(R.drawable.ic_baseline_pause_24)
            }
            songNames()
        }

        next.setOnClickListener {

            if (currentIndex < songs.size - 1) {
                currentIndex++
            } else {
                currentIndex = 0
            }

            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
            }

            mediaPlayer = MediaPlayer.create(applicationContext, songs[currentIndex])
            mediaPlayer.start()
            songNames()
        }

        prev.setOnClickListener {

            if (currentIndex > 0) {
                currentIndex--
            } else {
                currentIndex = songs.size - 1
            }

            if (mediaPlayer.isPlaying) {
                mediaPlayer.stop()
            }

            mediaPlayer = MediaPlayer.create(applicationContext, songs[currentIndex])
            mediaPlayer.start()
            songNames()
        }

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
    }

    private fun songNames() {
        if (currentIndex == 0 ) {
            title.setText("Cik Cik Periuk")
            detail.setText(R.string.cikcik)
        }
        if (currentIndex == 1 ) {
            title.setText("Sungai Kapuas")
            detail.setText(R.string.sungai_kapuas)
        }
        if (currentIndex == 2 ) {
            title.setText("Tanah Parenean")
            detail.setText(R.string.tanah_parenean)
        }
        if (currentIndex == 3 ) {
            title.setText("Jubata")
            detail.setText(R.string.jubata)
        }

        mediaPlayer.setOnPreparedListener(object : MediaPlayer.OnPreparedListener {
            override fun onPrepared(mp: MediaPlayer?) {
                seekBar.max = mediaPlayer.duration
                mediaPlayer.start()
            }
        })

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress)
                    seekBar?.setProgress(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        Thread(object : Runnable {
            override fun run() {
                while (mediaPlayer != null) {
                    try {
                        if (mediaPlayer.isPlaying) {
                            val message = Message()
                            message.what = mediaPlayer.currentPosition
                            handler.sendMessage(message)
                            Thread.sleep(1000)
                        }
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }
        }).start()
    }

    private val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            seekBar.setProgress(msg.what)
        }
    }
}