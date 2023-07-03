package com.example.folklor.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.folklor.R
import com.example.folklor.ui.activitys.MarginItemDecoration
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val adapter = PDFListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.addItemDecoration(MarginItemDecoration(6,16))
        recyclerView.adapter = adapter
        adapter.setOnClickItemListener {
            val intent = Intent(requireContext(),PDFReaderViewActivity::class.java)
            intent.putExtra(PDFReaderViewActivity.ID,it)
            startActivity(intent)
            Toast.makeText(requireContext(),"item clicked $it",Toast.LENGTH_LONG).show()
        }
    }

}