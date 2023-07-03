package com.example.folklor.ui.slideshow

import android.os.AsyncTask
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.folklor.R
import com.github.barteksc.pdfviewer.PDFView
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle
import kotlinx.android.synthetic.main.activity_user_read.*
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class UserReadActivity : AppCompatActivity() {

    companion object{
        const val ID = "id"
        const val URLID ="uriId"
    }

    var s = ""
    var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_read)

        s = intent.getStringExtra(URLID)?: ""
        name = intent.getStringExtra(ID)?: ""

        //back button
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = name

        /*Log.d(s, "bibi")
//        val uri = Uri.parse(s)
        Toast.makeText(this, "item clicked $s", Toast.LENGTH_LONG).show()*/

        RetrivePdfStream().execute(s)
    }

    inner class RetrivePdfStream : AsyncTask<String?, Void?, InputStream?>() {

        // Here load the pdf and dismiss the dialog box
        override fun onPostExecute(inputStream: InputStream?) {
            pdfViewUser.fromStream(inputStream)
                    .enableSwipe(true)
                    .swipeHorizontal(false)
                    .defaultPage(0)
                    .enableAnnotationRendering(true)
                    .scrollHandle(DefaultScrollHandle(this@UserReadActivity))
                    .spacing(2)
                    .load()
        }

        override fun doInBackground(vararg p0: String?): InputStream? {
            var inputStream: InputStream? = null
            try {
                // adding url
                val url = URL(p0[0])
                val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection

                // if url connection response code is 200 means ok the execute
                if (urlConnection.responseCode == 200) {
                    inputStream = BufferedInputStream(urlConnection.inputStream)
                }
            } // if error return null
            catch (e: IOException) {
                return null
            }
            return inputStream
        }
    }

    //back button clicked
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

//        var path = getExternalFilesDir(null)?.absolutePath.toString() + pdfList[n]
//        val file = File(path)

        when(item.itemId){
            android.R.id.home -> finish()
//            R.id.item_share -> {
//                val shareIntent: Intent = Intent().apply {
//                    action = Intent.ACTION_SEND
//                    putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file))
//                    type = "application/pdf"
//                }
//                Toast.makeText(this, pdfList[n], Toast.LENGTH_LONG).show()
//                startActivity(shareIntent)
//            }
        }
        return super.onOptionsItemSelected(item)
    }

}