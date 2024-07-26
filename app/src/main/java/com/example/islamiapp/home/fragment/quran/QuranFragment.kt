package com.example.islamiapp.home.fragment.quran

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamiapp.databinding.FragmentQuranBinding
import com.example.islamiapp.home.fragment.quran.Adapters.SuraNamesAdapter


class QuranFragment : Fragment() {
    lateinit var binding: FragmentQuranBinding
    lateinit var surasAdapter :SuraNamesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding=FragmentQuranBinding.inflate(inflater,container,false)

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        surasAdapter = SuraNamesAdapter(suraName = Constants.SURAS_NAMES_LIST)
        surasAdapter.onSuraClick = object :SuraNamesAdapter.recyclerviewclicked{
            override fun onItemClick(suraName: String, index: Int) {
             val intent = Intent(activity , SuraDetailsActivity::class.java)
             intent.putExtra(Constants.FILE_NAME,"${index+1}.txt")
             intent.putExtra(Constants.SURA_NAME , suraName)
                startActivity(intent)
            }

        }
        binding.suraNamesRecycleView.adapter = surasAdapter
    }

}