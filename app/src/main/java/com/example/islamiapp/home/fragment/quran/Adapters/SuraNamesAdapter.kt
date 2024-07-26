package com.example.islamiapp.home.fragment.quran.Adapters
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.R

class SuraNamesAdapter(var suraName:List<String>): RecyclerView.Adapter<SuraNamesAdapter.ViewHolder>() {





    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sura_title,
            parent , false)
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val  suraName = suraName[position]
        holder.suraNameTv.text = suraName

        if (onSuraClick!=null){
        holder.itemView.setOnClickListener{
          onSuraClick!!.onItemClick(suraName , position)
        }
        }
    }


    override fun getItemCount(): Int = suraName.size


    var onSuraClick:recyclerviewclicked?=null


    interface recyclerviewclicked{

        fun onItemClick(suraName:String , index:Int)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val suraNameTv : TextView = itemView.findViewById(R.id.itemSuraNameTv)
    }
}