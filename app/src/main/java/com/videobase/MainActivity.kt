package com.videobase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.videobase.network.ShowApi
import com.videobase.network.ShowsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = ShowsRepository(ShowApi())


        GlobalScope.launch(Dispatchers.Main) {
            val shows = repository.getShows()
            Toast.makeText(this@MainActivity,shows[4].summary,Toast.LENGTH_LONG).show()
        }


//                        txt.text =
//                            HtmlCompat.fromHtml(data[10].summary, HtmlCompat.FROM_HTML_MODE_LEGACY)
//                        Glide.with(this@MainActivity)
//                            .load(data[10].image.original.toString())
//                            .into(image)
//
    }
}