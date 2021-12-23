package com.example.folklor.ui.slideshow

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.folklor.R
import com.example.folklor.data.Users
import com.example.folklor.ui.activitys.MainActivity
import com.example.folklor.ui.activitys.MarginItemDecoration
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_home.*
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
        (requireActivity() as MainActivity?)?.UserLisFunction(mDatabase,madapter)



    }
}