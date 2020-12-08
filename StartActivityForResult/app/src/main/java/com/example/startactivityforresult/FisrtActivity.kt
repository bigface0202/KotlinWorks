package com.example.startactivityforresult

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_fisrt.*
import kotlinx.android.synthetic.main.activity_second.*

class FisrtActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fisrt)

        btn_finish.setOnClickListener{
            setResult(Activity.RESULT_OK)
            finish()
        }
    }
}