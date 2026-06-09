package com.example.knowledgehub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 0, systemBars.right, systemBars.bottom)
            insets
        }

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)

        ViewCompat.setOnApplyWindowInsetsListener(toolbar) { view, insets ->
            val statusBarHeight =
                insets.getInsets(WindowInsetsCompat.Type.statusBars()).top
            view.setPadding(
                view.paddingLeft,
                statusBarHeight,
                view.paddingRight,
                view.paddingBottom,
            )
            insets
        }

        val recyclerView =
            findViewById<RecyclerView>(R.id.rvTechnology)

        recyclerView.layoutManager =
            GridLayoutManager(this, 2)

        recyclerView.adapter =
            TechAdapter(Constants.techList) { technology ->
                val intent = Intent(this, ThirdActivity::class.java)
                intent.putExtra("title", technology.title)
                intent.putExtra("description", technology.description)
                intent.putExtra("imageUrl", technology.imageUrl)
                intent.putExtra("url", technology.url)
                startActivity(intent)
            }

        val callBtn = findViewById<Button>(R.id.call_btn)
        callBtn.setOnClickListener {
            startActivity(
                Intent(Intent.ACTION_DIAL).apply {
                    data = "tel:9876543210".toUri()
                },
            )
        }
    }
}
