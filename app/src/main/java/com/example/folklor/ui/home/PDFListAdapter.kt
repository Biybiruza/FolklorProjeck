package com.example.folklor.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.folklor.R

class PDFListAdapter : RecyclerView.Adapter<PDFListAdapter.PDFViewHolder>() {

    inner class PDFViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun populateModel(n: Int,onClick:(it:Int)->Unit){
            val imageResName = "folklor${n}"
            Glide
                    .with(itemView)
                    .load(itemView.context.resources.getIdentifier(imageResName,"drawable",itemView.context.packageName))
                    .centerCrop()
                    .into(itemView.findViewById(R.id.ImageViewBook))
            itemView.setOnClickListener {
                onClick.invoke(n)
            }
        }
    }

    private var onClick:(it:Int)->Unit = {}

    fun setOnClickItemListener(onClick:(it:Int)->Unit){
        this.onClick = onClick
    }

    private var pdfList = listOf<Int>(1,2,3,4,5,6,7)
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PDFViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book,parent,false)
        return PDFViewHolder(view)
    }

    override fun onBindViewHolder(holder: PDFViewHolder, position: Int) {
        holder.populateModel(pdfList[position],onClick)
    }

    override fun getItemCount(): Int = pdfList.size
}