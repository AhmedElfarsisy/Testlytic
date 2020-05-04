package com.elfarsisy.lovetypetest.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.core.os.postDelayed
import com.elfarsisy.lovetypetest.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed(
            Runnable { startActivity(Intent(applicationContext,HomeActivity::class.java))
                finish()
            },
            2000
        )
    }
}
