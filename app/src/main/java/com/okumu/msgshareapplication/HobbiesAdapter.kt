package com.okumu.msgshareapplication

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.okumu.msgshareapplication.databinding.ListItemBinding

class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby)
        Log.d("HobbiesAdapter", "onBindViewHolder: position = $position, hobby = ${hobby.title}")
    }

    inner class MyViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(hobby: Hobby?) {
            binding.txvTitle.text = hobby?.title ?: ""
            Log.d("MyViewHolder", "setData: hobby = ${hobby?.title}")
        }
    }
}
