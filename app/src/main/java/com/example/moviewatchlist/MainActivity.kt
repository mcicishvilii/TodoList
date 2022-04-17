package com.example.moviewatchlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviewatchlist.databinding.ActivityMainBinding
import com.example.moviewatchlist.databinding.LayoutMovieItemBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RVTodoList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)




        binding.RVTodoList.adapter = MoviesAdapter(
            mutableListOf(
                Todo(
                    ""
                )
            )
        ).apply {

            binding.BTNAddbutton.setOnClickListener {


                todoListList.add(Todo(binding.ETEnterTask.text.toString()))
                notifyDataSetChanged()

                Toast.makeText(this@MainActivity,"${binding.ETEnterTask.text.toString()} added",Toast.LENGTH_SHORT).show()
            }

            setOnItemCLickListener { task: Todo, i: Int ->
                todoListList.remove(task)
                notifyItemChanged(0)
                notifyItemRangeChanged(0,5)

                Toast.makeText(this@MainActivity,"${binding.ETEnterTask.text.toString()} completed",Toast.LENGTH_SHORT).show()

            }

        }
    }
}





