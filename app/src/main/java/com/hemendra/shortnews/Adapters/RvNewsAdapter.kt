package com.hemendra.shortnews.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hemendra.shortnews.Models.News
import com.hemendra.shortnews.NewsFullActivity
import com.hemendra.shortnews.R

class RvNewsAdapter(val context: Context,val NewsList: News) : RecyclerView.Adapter<RvNewsAdapter.ViewHolder>() {


    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cat_rv_news_item, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewCatName.text=NewsList.items[position].title;
        Glide.with(context)
            .load(NewsList.items[position].imageUrl)
            .into(holder.newsimageview)
        holder.linerlayout.setOnClickListener {
            val intent = Intent(context, NewsFullActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.putExtra("newsurl",NewsList.items[position].newsUrl)
            intent.putExtra("title",NewsList.items[position].title)
            intent.putExtra("imageurl",NewsList.items[position].imageUrl)

            context.startActivity(intent)
        }
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return NewsList.items.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

            val textViewCatName = itemView.findViewById(R.id.rv_news_title) as TextView
            val newsimageview =itemView.findViewById(R.id.rv_news_imageview) as ImageView
            val linerlayout = itemView.findViewById(R.id.ll) as LinearLayout



    }
}