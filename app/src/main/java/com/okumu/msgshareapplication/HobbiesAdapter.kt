package com.okumu.msgshareapplication

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
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

        var currentHobby: Hobby? = null
//        var currentPosition: Int = 0
        init {
            binding.root.setOnClickListener{
                currentHobby?.let {
                    Toast.makeText(context, currentHobby!!.title + " Clicked !", Toast.LENGTH_SHORT).show()
                }

                binding.imgShare.setOnClickListener{
                    currentHobby?.let {
                        val message: String = "My hobby is: " + currentHobby!!.title
                        val intent = Intent()
                        intent.action = Intent.ACTION_SEND
                        intent.putExtra(Intent.EXTRA_TEXT, message)
                        intent.type = "text/plain"

                        context.startActivity(Intent.createChooser(intent, "Share to: "))
                    }
                }
            }
        }
        fun setData(hobby: Hobby?) {
            binding.txvTitle.text = hobby?.title ?: ""
            Log.d("MyViewHolder", "setData: hobby = ${hobby?.title}")
            this.currentHobby = hobby
//            this.currentPosition = pos
        }
    }
}
