package com.example.UsersApp


import android.app.AlertDialog
import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.UsersApp.databinding.LayoutUserItemWithAgeBinding
import com.example.UsersApp.databinding.LayoutWithLastnameItemBinding

class UsersAdapter : ListAdapter<User, RecyclerView.ViewHolder>(DiffCallBack())
{


    private lateinit var itemClickListener: (User, Int) -> Unit
    private lateinit var deleteCLickListener: (User, Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        return when(viewType){
            WITH_LAST_NAME -> UsersViewHolder(
                LayoutWithLastnameItemBinding.inflate
                (LayoutInflater.from(parent.context),
                parent,
                false)
            )
            else ->
            {UsersViewHolderWithAge(
                LayoutUserItemWithAgeBinding.inflate
                    (LayoutInflater.from(parent.context),
                    parent,
                    false)
            )
            }
        }
    }



    fun setOnDeleteClickListener(clickListener: (User, Int) -> Unit)
    {
        this.deleteCLickListener = clickListener
    }

    fun setOnItemClickListener(clickListener: (User, Int) -> Unit)
    {
        this.itemClickListener = clickListener
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int)
    {
        when (holder) {
            is UsersViewHolder -> holder.bind()
            is UsersViewHolderWithAge -> holder.bind()
        }

    }

    override fun getItemViewType(position: Int): Int {
        val user = getItem(position)
        return when (user.age) {
            null -> WITH_AGE
            else -> WITH_LAST_NAME
        }
    }


    inner class UsersViewHolder(val binding: LayoutWithLastnameItemBinding) :
        RecyclerView.ViewHolder(binding.root)
    {
        fun bind()
        {
            val currentUser = getItem(adapterPosition)
            binding.tvFirstName.text = currentUser.firstName
            binding.tvLastName.text = currentUser.lastName

            binding.mMenus.setOnClickListener {
                deleteCLickListener.invoke(currentUser, adapterPosition)
            }

            binding.mainLayout.setOnClickListener {
                itemClickListener.invoke(currentUser, adapterPosition)
            }
        }
    }

    inner class UsersViewHolderWithAge(val binding: LayoutUserItemWithAgeBinding) :
        RecyclerView.ViewHolder(binding.root)
    {
        fun bind()
        {
            val currentUser = getItem(adapterPosition)
            binding.tvFirstName.text = currentUser.firstName
            binding.tvAge.text = currentUser.age.toString()

            binding.mMenus.setOnClickListener {
                deleteCLickListener.invoke(currentUser, adapterPosition)
            }

            binding.mainLayout.setOnClickListener {
                itemClickListener.invoke(currentUser, adapterPosition)
            }
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<User>()
    {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean
        {
            return oldItem.lastName == newItem.lastName
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean
        {
            return oldItem == newItem
        }
    }

    companion object UserTypes {
        const val WITH_LAST_NAME = 1
        const val WITH_AGE = 2
    }




}







