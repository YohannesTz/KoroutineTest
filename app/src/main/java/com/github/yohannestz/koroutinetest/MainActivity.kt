package com.github.yohannestz.koroutinetest

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        repeat(1_000_000) {index -> // launch a lot of coroutines
            Thread {
                val uiHandler = Handler(Looper.getMainLooper())
                uiHandler.post {
                    textView.text = "Update text from $index"
                }
            }
        }
    }
}