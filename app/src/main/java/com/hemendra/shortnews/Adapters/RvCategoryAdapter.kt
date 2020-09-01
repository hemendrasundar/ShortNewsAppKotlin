package com.hemendra.shortnews.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hemendra.shortnews.R

class RvCategoryAdapter : RecyclerView.Adapter<RvCategoryAdapter.ViewHolder>() {
val catnamesarr = arrayOf("General","Sports","Health","Business","Entertainment")
    //this method is returning the view for each item in the list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cat_rv_item, parent, false)
        return ViewHolder(v)
    }

    //this method is binding the data on the list
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textViewCatName.text=catnamesarr[position];
    }

    //this method is giving the size of the list
    override fun getItemCount(): Int {
        return catnamesarr.size
    }

    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val textViewCatName = itemView.findViewById(R.id.rv_cat_textview) as TextView




    }
}