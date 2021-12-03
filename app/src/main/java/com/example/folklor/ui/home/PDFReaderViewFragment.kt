package com.example.folklor.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.folklor.R
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import kotlinx.android.synthetic.main.fragment_p_d_f_reader_view.*

class PDFReaderViewFragment : Fragment(R.layout.fragment_p_d_f_reader_view) {

    companion object{
        const val ID = "id"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pdfList: List<String> = listOf("Qaraqalpaq folklori. Alpamis.pdf",
            "Qaraqalpaq folklori. Er Ziywar. Qurbanbek.pdf",
            "Qaraqalpaq folklori. Naqil-maqallar.pdf","Qaraqalpaq folklori. Jumbaqlar.pdf","Qaraqalpaq folklori. Qoblan.pdf",
            "Qaraqalpaq folklori. Qiriq qiz.pdf","Qaraqalpaq folklori. Shariyar. Qanshayim (1997).pdf")

        var n = requireArguments().getInt(PDFReaderView.ID,0)

        pdfViewFragment.fromAsset(pdfList[n])
            .enableSwipe(true)
            .swipeHorizontal(false)
            .defaultPage(0)
            .enableAnnotationRendering(true)
            .scrollHandle(DefaultScrollHandle(context))
            .spacing(2)
            .load()
    }

}