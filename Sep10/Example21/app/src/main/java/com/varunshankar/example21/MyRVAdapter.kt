package com.varunshankar.example21

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import java.util.ArrayList

class MyRVAdapter(private val mListItems: ArrayList<String>?) :
    RecyclerView.Adapter<MyRVAdapter.ViewHolder>() {
    private var mContext: Context? = null

    class ViewHolder(var itemLayout: View) : RecyclerView.ViewHolder(
        itemLayout
    ) {
        var itemTvData: TextView = itemLayout.findViewById<View>(R.id.tv_data) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val layoutInflater = LayoutInflater.from(mContext)
        val myView = layoutInflater.inflate(R.layout.item_layout, parent, false)
        return ViewHolder(myView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemTvData.text = mListItems!![position]
        holder.itemLayout.setOnClickListener { remove(holder.absoluteAdapterPosition) }
    }

    private fun remove(position: Int) {
        mListItems!!.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun getItemCount(): Int {
        return mListItems!!.size
    }
}