package com.example.UsersApp


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.UsersApp.databinding.LayoutMovieItemBinding

class UsersAdapter : ListAdapter<User,UsersAdapter.UsersViewHolder>(DiffCallBack()) {


    private lateinit var itemClickListener: (User,Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val binding =
            LayoutMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersViewHolder(binding)
    }


    fun setOnDeleteClickListener(clickListener: (User,Int) -> Unit) {
        itemClickListener = clickListener
    }

//    fun setOnItemCLickListener(clickListener: (User,Int) -> Unit) {
//        itemClickListener = clickListener
//    }


    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val user = getItem(position)
        holder.bind(user)


        holder.binding.tvFirstName.setOnClickListener {
            itemClickListener.invoke(user,position)
        }
    }


    inner class UsersViewHolder(val binding: LayoutMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(user: User){
                binding.tvFirstName.text = user.firstName
                binding.tvLastName.text = user.lastName

                itemClickListener.invoke(user,adapterPosition)
            }



    }

    class DiffCallBack : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.lastName == newItem.lastName
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }
    }
}







