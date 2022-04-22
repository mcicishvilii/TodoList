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

class MoviesAdapter( var todoListList: MutableList<Todo>) : RecyclerView.Adapter<TodolistViewHolder>() {


    private lateinit var itemClickListener: (Todo,Int) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodolistViewHolder {
        val binding =
            LayoutMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodolistViewHolder(binding)
    }



    fun setOnItemCLickListener(clickListener: (Todo,Int) -> Unit) {
        itemClickListener = clickListener
    }


    override fun onBindViewHolder(holder: TodolistViewHolder, position: Int) {

        val task = todoListList[position]
        holder.binding.TWTaskName.text = task.taskName

        holder.binding.TWTaskName.setOnClickListener {
            itemClickListener.invoke(task,position)
            holder.binding.indicator.setBackgroundColor(Color.GREEN)


            if (task.isComplete) {
                 holder.binding.indicator.setBackgroundColor(Color.GREEN)

            } else {
                  holder.binding.indicator.setBackgroundColor(Color.RED)

            }
        }
    }

    fun addItem(todoItem:Todo){
       todoListList.add(0, todoItem)
       notifyItemInserted(0)
    }

    override fun getItemCount(): Int {
        return todoListList.size
    }
}


data class Todo(
    var taskName: String,
    var isComplete:Boolean = false
)

class TodolistViewHolder(val binding: LayoutMovieItemBinding) :
    RecyclerView.ViewHolder(binding.root) {

}
