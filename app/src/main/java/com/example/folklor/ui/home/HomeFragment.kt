package com.example.folklor.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.folklor.R
import com.example.folklor.ui.MarginItemDecoration
import com.github.barteksc.pdfviewer.PDFView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {

    private val adapter = PDFListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.addItemDecoration(MarginItemDecoration(16,128))
        recyclerView.adapter = adapter
        adapter.setOnClickItemListener {
            val intent = Intent(requireContext(),PDFView::class.java)
            intent.putExtra(PDFReaderView.ID,it)
            startActivity(intent)
            Toast.makeText(requireContext(),"item clicked",Toast.LENGTH_LONG).show()
        }
    }

}