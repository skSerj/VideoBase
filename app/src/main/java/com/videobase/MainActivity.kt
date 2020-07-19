package com.videobase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.text.HtmlCompat
import com.bumptech.glide.Glide
import com.videobase.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        GlobalScope.launch {
            try {
                val response = ApiService.getShowList()
                if (response.isSuccessful && response.body() != null) {
                    val data = response.body()!!
                    withContext(Dispatchers.Main) {
                        txt.text =
                            HtmlCompat.fromHtml(data[10].summary, HtmlCompat.FROM_HTML_MODE_LEGACY)
                        Glide.with(this@MainActivity)
                            .load(data[10].image.original.toString())
                            .into(image)
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Api has Error", Toast.LENGTH_LONG).show()
                }
            } catch (e: Exception) {
                Toast.makeText(this@MainActivity, " Error: ${e.message}", Toast.LENGTH_LONG).show()
            }
        }
    }
}