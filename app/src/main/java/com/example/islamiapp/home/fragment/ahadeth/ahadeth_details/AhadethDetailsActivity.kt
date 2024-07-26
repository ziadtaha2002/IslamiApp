package com.example.islamiapp.home.fragment.ahadeth.ahadeth_details

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.islamiapp.R
import com.example.islamiapp.databinding.ActivityAhadethDetailsBinding
import com.example.islamiapp.home.fragment.ahadeth.model.HadethModel
import com.example.islamiapp.home.fragment.quran.Constants

class AhadethDetailsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAhadethDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAhadethDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var hadeth = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(Constants.HADETH,HadethModel::class.java)
        } else {
            intent.getSerializableExtra(Constants.HADETH)as HadethModel
        }

        binding.hadethnameTv.text = hadeth!!.title
        binding.hadethContentTv.text=hadeth.content
    }
}