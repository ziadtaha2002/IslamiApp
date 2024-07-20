package com.example.islamiapp.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.islamiapp.R
import com.example.islamiapp.home.HomeActivity

class SplashActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        startHomeScreen()
    }

    private fun startHomeScreen() {

        Handler().postDelayed({
            val intent = Intent(this , HomeActivity::class.java)
            startActivity(intent)
        }, 2000)
        finish()


    }
}