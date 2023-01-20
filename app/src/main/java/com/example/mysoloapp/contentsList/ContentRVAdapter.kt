package com.example.mysoloapp.contentsList

import android.content.ClipData.Item
import android.content.Context
import android.icu.lang.UCharacter.GraphemeClusterBreak.V
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.mysoloapp.ContentModel
import com.example.mysoloapp.R

class ContentRVAdapter(val context: Context, val items: ArrayList<ContentModel>) : RecyclerView.Adapter<ContentRVAdapter.ViewHolder>() {

        //~~~~ 클릭 이벤트를 위한 인터페이스
    interface ItemClick{
        fun onClick(view:View, position:Int)
    }

    var itemClick:ItemClick?=null

    //


    ///1. onCreateViewHolder: 뷰 홀더 생성(레이아웃 生 )
    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int):ContentRVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.content_rv_item,parent,false)
        return ViewHolder(v)
    }


    //2. onBindViewHolder : 뷰 홀더가 재활용될 때 실행되는 메서드
    override fun onBindViewHolder(holder:ContentRVAdapter.ViewHolder, position:Int) {

        if(itemClick!=null) {
            holder.itemView.setOnClickListener{
                v->itemClick?.onClick(v,position)
            }

        }

        holder.bindItems(items[position])
    }


    override fun getItemCount(): Int {
        return items.size
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(item:ContentModel) {
            val contentTitle = itemView.findViewById<TextView>(R.id.textArea)

            val imageViewArea = itemView.findViewById<ImageView>(R.id.imageArea)

            contentTitle.text = item.title

            Glide.with(context) // View, Fragment 혹은 Activity로부터 Context를 가져온다.
                .load(item.imageUrl)
                .into(imageViewArea)
        }
    }
}