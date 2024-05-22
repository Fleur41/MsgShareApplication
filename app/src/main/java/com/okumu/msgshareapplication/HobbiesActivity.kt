package com.okumu.msgshareapplication

import android.os.Build.VERSION_CODES.S
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.okumu.msgshareapplication.databinding.ActivityHobbiesBinding

class HobbiesActivity: AppCompatActivity() {
    private lateinit var binding: ActivityHobbiesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHobbiesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Display of the recyclerView
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager = layoutManager

        //Adapter
        val adapter = HobbiesAdapter(this, Supplier.hobbies)
        binding.recyclerView.adapter = adapter
    }
}