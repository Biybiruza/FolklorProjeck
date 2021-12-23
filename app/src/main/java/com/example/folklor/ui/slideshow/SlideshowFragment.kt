package com.example.folklor.ui.slideshow

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.folklor.R
import com.example.folklor.data.Users
import com.example.folklor.ui.activitys.MarginItemDecoration
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_slideshow.*

class SlideshowFragment : Fragment(R.layout.fragment_slideshow) {

    lateinit var mDatabase: DatabaseReference
    private val madapter = UserListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mDatabase = FirebaseDatabase.getInstance().getReference("Users")
        recyclerViewFirebase.setHasFixedSize(true);
        recyclerViewFirebase.layoutManager = LinearLayoutManager(requireContext());
        recyclerViewFirebase.addItemDecoration(MarginItemDecoration(6,16))
        UserListFunction(mDatabase,madapter)
    }
    private fun UserListFunction(mDatabase: DatabaseReference, madapter: UserListAdapter){
        var userList = arrayListOf<Users>()
        // Read from the database
        mDatabase.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (userSnapshot in dataSnapshot.children){
                    val value = userSnapshot.getValue(Users::class.java)
                    userList.add(value!!)
                }
                madapter.list = userList
                recyclerViewFirebase.adapter = madapter
                Log.d(ContentValues.TAG, "Value is: ")
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w(ContentValues.TAG, "Failed to read value.", error.toException())
            }
        })
    }

}