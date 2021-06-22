package org.sumin.phonebook

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity :AppCompatActivity(){
    val splashDelay: Long = 500        //스플래시타임 0.5초

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }, splashDelay)
    }
}