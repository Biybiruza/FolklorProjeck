package com.example.folklor.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.folklor.R
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import kotlinx.android.synthetic.main.activity_p_d_f_reader_view.*

class PDFReaderView : AppCompatActivity() {

    companion object{
        const val ID = "id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_p_d_f_reader_view)
        val pdfList: List<String> = listOf("Qaraqalpaq folklori. Alpamis.pdf",
            "Qaraqalpaq folklori. Er Ziywar. Qurbanbek.pdf",
            "Qaraqalpaq folklori. Naqil-maqallar.pdf","Qaraqalpaq folklori. Jumbaqlar.pdf","Qaraqalpaq folklori. Qoblan.pdf",
            "Qaraqalpaq folklori. Qiriq qiz.pdf","Qaraqalpaq folklori. Shariyar. Qanshayim (1997).pdf")

        //back button
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var n = intent.getIntExtra(ID,0)

        pdfView.fromAsset(pdfList[n])
            .enableSwipe(true)
            .swipeHorizontal(false)
            .defaultPage(0)
            .enableAnnotationRendering(true)
            .scrollHandle(DefaultScrollHandle(this))
            .spacing(2)
            .load()
    }
    //back button clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}