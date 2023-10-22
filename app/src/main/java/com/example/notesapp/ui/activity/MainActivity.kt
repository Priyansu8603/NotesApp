package com.example.notesapp.ui.activity

import android.content.Intent
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notesapp.R
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startHeavyTask()
    }
    private fun startHeavyTask() {
        LongOperation().execute()
    }
    private open inner class LongOperation : AsyncTask<String?, Void, String?>() {
        override fun doInBackground(vararg p0: String?): String? {
            for (i in 0..3) {
                try {
                    Thread.sleep(1000)
                } catch (e: Exception) {
                    Thread.interrupted()
                }
            }
            return "result"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            val intent = Intent(this@MainActivity, notes::class.java)
            startActivity(intent)
        }
    }
}