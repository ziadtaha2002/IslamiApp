package com.example.islamiapp.home.fragment.ahadeth

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamiapp.databinding.FragmentAhadethBinding
import com.example.islamiapp.home.fragment.ahadeth.ahadeth_details.AhadethDetailsActivity
import com.example.islamiapp.home.fragment.ahadeth.model.HadethModel
import com.example.islamiapp.home.fragment.quran.Adapters.AhadethAdapter
import com.example.islamiapp.home.fragment.quran.Constants
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

//
class AhadethFragment : Fragment() {

    lateinit var binding: FragmentAhadethBinding
    var ahadeth = mutableListOf<HadethModel>()
    lateinit var ahadethAdapter: AhadethAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding= FragmentAhadethBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        readAhadeth()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        ahadethAdapter = AhadethAdapter(ahadeth)
        ahadethAdapter.onHadethClick= object : AhadethAdapter.recyclerviewclicked{
            override fun onItemClick(hadeth: HadethModel, index: Int) {
              val intent = Intent(activity , AhadethDetailsActivity::class.java)
                intent.putExtra(Constants.HADETH , hadeth)
                startActivity(intent)
            }

        }

        binding.ahadethRecyclerView.adapter = ahadethAdapter
    }

    private fun readAhadeth() {
            try {
                val inputStream = requireActivity().assets.open("ahadeeth.txt")
                val reader = BufferedReader(InputStreamReader(inputStream))
                var hadethFileContent = reader.readText()
                var ahadethList:List<String> = hadethFileContent.split("#")

                for ( hadeth:String in ahadethList){
                    var singleHadethWithSpace = hadeth.trim()
                    var singleHadethLines:MutableList<String> =singleHadethWithSpace.split("\n").toMutableList()
                    val hadetTitle = singleHadethLines[0]
                    singleHadethLines.removeAt(0)

                    var content = singleHadethLines.joinToString (" "){
                        return@joinToString it
                    }

                    ahadeth.add(HadethModel(title = hadetTitle , content = content))
                }

                Log.e("AhadethFragment/readhadethContent: ", "hadethlist  = ${ahadethList}" )
                inputStream.close()
            }catch (e: IOException){
                e.printStackTrace()
            }
         }

}
