package com.example.startactivityforresult

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        private const val FIRST_ACTIVITY_REQUEST_CODE = 1
        private const val SECOND_ACTIVITY_REQUEST_CODE = 2

        const val NAME = "name"
        const val EMAIL = "email"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_launch_activity_first.setOnClickListener {
            val intent = Intent(this, FisrtActivity::class.java)
            startActivityForResult(intent, FIRST_ACTIVITY_REQUEST_CODE)
        }

        btn_launch_activity_second.setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == Activity.RESULT_OK){
            if(requestCode == FIRST_ACTIVITY_REQUEST_CODE){
                tv_first_activity_result.text = "First Activity Result Success"
            }else if(requestCode == SECOND_ACTIVITY_REQUEST_CODE){
                if(data!=null){
                    val name = data.getStringExtra(NAME)
                    val email = data.getStringExtra(EMAIL)
                    tv_second_activity_result.text = "$email"

                }


            }
        }else if(resultCode == Activity.RESULT_CANCELED){
            Log.e("Cancelled", "Cancelled")
            Toast.makeText(this@MainActivity, "ResultCanselled", Toast.LENGTH_SHORT).show()
        }
    }
}