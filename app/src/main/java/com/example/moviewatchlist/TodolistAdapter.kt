package com.example.moviewatchlist

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintSet
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviewatchlist.databinding.LayoutMovieItemBinding

class UsersAdapter( var usersList: MutableList<User>) : RecyclerView.Adapter<UsersViewHolder>() {


    private lateinit var itemClickListener: (User,Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding =
            LayoutMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersViewHolder(binding)
    }


    fun setOnItemCLickListener(clickListener: (User,Int) -> Unit) {
        itemClickListener = clickListener
    }


    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {

        val user = usersList[position]
        holder.binding.TWUsername.text = user.firstName

        holder.binding.TWUsername.setOnClickListener {
            itemClickListener.invoke(user,position)
            holder.binding.indicator.setBackgroundColor(Color.GREEN)


            if (user.isDeleted) {
                 holder.binding.indicator.setBackgroundColor(Color.GREEN)

            } else {
                  holder.binding.indicator.setBackgroundColor(Color.RED)

            }
        }
    }

    override fun getItemCount(): Int {
        return usersList.size
    }
}



data class User(
    var firstName: String,
    var isDeleted:Boolean = false
)


class UsersViewHolder(val binding: LayoutMovieItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

}
