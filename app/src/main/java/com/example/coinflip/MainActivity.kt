package com.example.coinflip

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

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
        Toast.makeText(this, "fej test", Toast.LENGTH_SHORT).show()
    }

    fun IrasTipp() {
        Toast.makeText(this, "iras test", Toast.LENGTH_SHORT).show()
    }

    fun DefaultSetting() {
        dobasok = 0
        win = 0
        lose = 0
    }
}