package com.example.folklor.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.folklor.R
import com.synnapps.carouselview.ImageListener
import com.synnapps.carouselview.ViewListener
import kotlinx.android.synthetic.main.fragment_gallery.*

class GalleryFragment : Fragment(R.layout.fragment_gallery) {

    private var photoList = arrayOf(R.drawable.foto1,R.drawable.foto2,R.drawable.foto3,R.drawable.foto4,R.drawable.foto5)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        carouselView.setImageListener { position, imageView ->
            imageView.setImageResource(photoList[position])
        }
        carouselView.pageCount = photoList.count()
    }
}