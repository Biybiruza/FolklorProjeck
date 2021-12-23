package com.example.folklor.ui.slideshow

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.folklor.R
import com.example.folklor.data.Users
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_book.view.*

class UserListAdapter: RecyclerView.Adapter<UserListAdapter.UserListViewHolder>() {

    inner class UserListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(model: Users) {
            Picasso.get().load(model.imageUrl).centerCrop().into(itemView.ImageViewBook)
            Log.d(model.imageUrl,"magliwmat")
        }
    }

        var list = arrayListOf<Users>()
            set(value) {
                field = value
                notifyDataSetChanged()
            }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
            return UserListViewHolder(view)
        }

        override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
            holder.populateModel(list[position])
        }

        override fun getItemCount(): Int = list.size
}