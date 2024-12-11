package com.example.moviesapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private var movieList :ArrayList<Movie>):RecyclerView.Adapter<MyAdapter.MyviewHolder>(){
    class MyviewHolder(view:View):RecyclerView.ViewHolder(view){
        val imageView : ImageView = view.findViewById(R.id.rv_image)
        val  tittleRv : TextView = view.findViewById(R.id.rvtitle)
        val  discriptionRv : TextView= view.findViewById(R.id.dis)
        val rate:TextView= view.findViewById(R.id.rate)

    }

   // @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
      val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return MyviewHolder(view)

    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        val currentItem= movieList[position]
        holder.imageView.setImageResource(currentItem.image)
        holder.tittleRv.text= currentItem.title
        holder.discriptionRv.text=currentItem.discription
        holder.rate.text=currentItem.rate

    }
    fun updateList(newList:ArrayList<Movie>){
        val diffutilCallBack = MyDiffUtil(oldList = this.movieList, newList = newList)
        val diffUtilResult = DiffUtil.calculateDiff(diffutilCallBack)
        this.movieList= newList
        diffUtilResult.dispatchUpdatesTo(this)
    }
}