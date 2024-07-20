package com.example.islamiapp.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islamiapp.R
import com.example.islamiapp.databinding.ActivityHomeBinding
import com.example.islamiapp.home.fragment.ahadeth.AhadethFragment
import com.example.islamiapp.home.fragment.quran.QuranFragment
import com.example.islamiapp.home.fragment.radio.RadioFragment
import com.example.islamiapp.home.fragment.sebha.SebhaFragment

class HomeActivity : AppCompatActivity() {
     val TAG = "main"
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startFragment(QuranFragment())
        initListeners()




        }

    private fun initListeners() {
        binding.bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.icQuran -> {
                    startFragment(QuranFragment())
                    true
                }
                R.id.icRadio -> {
                    startFragment(RadioFragment())
                    true
                }
                R.id.icSebha -> {
                    startFragment(SebhaFragment())
                    true
                }
                R.id.icHadeeth -> {
                    startFragment(AhadethFragment())
                    true
                }
                else -> false
            }
        }


    }

    private fun startFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().
        replace(R.id.fragmentContainer,fragment,"")
            .commit()
    }

    

}