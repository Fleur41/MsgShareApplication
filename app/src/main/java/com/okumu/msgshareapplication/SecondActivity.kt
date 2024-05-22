package com.okumu.msgshareapplication

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.okumu.msgshareapplication.databinding.ActivityMainBinding
import com.okumu.msgshareapplication.databinding.ActivitySecondBinding

class SecondActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        val msg = bundle!!.getString("user_message")
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

        binding.txtUserMessage.text = msg

    }
}