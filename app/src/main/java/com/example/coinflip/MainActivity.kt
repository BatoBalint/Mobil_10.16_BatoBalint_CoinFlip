package com.example.coinflip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var coin : ImageView
    lateinit var btnFej : Button
    lateinit var btnIras : Button
    lateinit var txtDobas : TextView
    lateinit var txtWin : TextView
    lateinit var txtLose : TextView
    var dobasok = 0
    var win = 0
    var lose = 0
    var coinFace = "heads"
    var animationPlaying = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Init()
        DefaultSetting()
    }

    fun Init() {
        coin = findViewById(R.id.coin_img)
        btnFej = findViewById(R.id.btn_fej)
        btnIras = findViewById(R.id.btn_iras)
        txtDobas = findViewById(R.id.txt_dobas)
        txtWin = findViewById(R.id.txt_win)
        txtLose = findViewById(R.id.txt_lose)

        btnFej.setOnClickListener {
            FejTipp()
        }

        btnIras.setOnClickListener {
            IrasTipp()
        }
    }

    fun FejTipp() {
        if (!animationPlaying) {
            var rnd = Random()
            CoinAnimation((rnd.nextInt(5) + 5) * 2)
        }
    }

    fun IrasTipp() {
        Toast.makeText(this, "iras test", Toast.LENGTH_SHORT).show()
    }

    fun CoinAnimation(rnd : Int) {
        animationPlaying = true
        var speed : Long = 100
        var tickCounter = 0
        val timer = object: CountDownTimer((rnd * speed).toLong(), speed) {
            override fun onTick(millisUntilFinished: Long) {
                if (tickCounter % 2 == 0) {
                    coin.animate().scaleX(0.02F).duration = speed/2
                } else {
                    if (millisUntilFinished < (rnd * speed) - 50) ChangeCoinFace()
                    coin.animate().scaleX(1F).duration = speed/2
                }
                tickCounter++
            }

            override fun onFinish() {
                animationPlaying = false
                Results()
            }
        }
        timer.start()
    }

    fun Results() {

    }

    fun ChangeCoinFace() {
        if (coinFace == "heads") {
            coin.setImageResource(R.drawable.tails)
            coinFace = "tails"
        } else {
            coin.setImageResource(R.drawable.heads)
            coinFace = "heads"
        }
    }

    fun DefaultSetting() {
        dobasok = 0
        win = 0
        lose = 0
    }
}