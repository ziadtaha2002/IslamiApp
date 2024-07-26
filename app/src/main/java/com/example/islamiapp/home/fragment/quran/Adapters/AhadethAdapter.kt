package com.example.islamiapp.home.fragment.quran.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.R
import com.example.islamiapp.home.fragment.ahadeth.model.HadethModel

class AhadethAdapter(var ahadeth:List<HadethModel>): RecyclerView.Adapter<AhadethAdapter.ViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_sura_title,
            parent , false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val  title = ahadeth[position].title
        holder.hadethNameTv.text = title

        if (onHadethClick!=null){
            holder.itemView.setOnClickListener{
                onHadethClick!!.onItemClick(ahadeth[position] , position)
            }
        }
    }


    override fun getItemCount(): Int = ahadeth.size


    var onHadethClick: recyclerviewclicked?=null


    interface recyclerviewclicked{

        fun onItemClick(Hadeth:HadethModel , index:Int)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val hadethNameTv : TextView = itemView.findViewById(R.id.itemSuraNameTv)
    }

}