package com.example.islamiapp.home.fragment.quran

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.islamiapp.R
import com.example.islamiapp.databinding.ActivitySuraDetailsBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class SuraDetailsActivity : AppCompatActivity() {

   lateinit var suraName : String
   lateinit var fileName :String
   lateinit var binding:ActivitySuraDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuraDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        suraName =intent.getStringExtra(Constants.SURA_NAME)!!
        fileName =intent.getStringExtra(Constants.FILE_NAME)!!
        binding.suraContentTv.text = readFileContent()
        binding.suranameTv.text = suraName

      // Log.e("SuraDetailsActivity","suraname = ${suraName} " + "fileName = ${fileName} " )

        readFileContent()
    }
    private fun readFileContent(): String {
        var fileContent = ""
        try {
            val inputStream = assets.open(fileName)
            val reader = BufferedReader(InputStreamReader(inputStream))
            val fileLines : List<String> = reader.readLines()
            fileContent = fileLines.joinToString (" "){line->
                var index = fileLines.indexOf(line) + 1
                return@joinToString line + "{${index}}"
            }
            Log.e("SuraDetailsActivity/readfileContent: ", "filelines = ${fileContent}" )
            inputStream.close()
        }catch (e:IOException){
            e.printStackTrace()
        }
        return fileContent
    }
}