package com.videobase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.videobase.network.ShowsApi
import com.videobase.network.ShowsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//                        txt.text =
//                            HtmlCompat.fromHtml(data[10].summary, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}