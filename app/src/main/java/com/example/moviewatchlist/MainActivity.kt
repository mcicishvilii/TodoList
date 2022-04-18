package com.example.moviewatchlist

import android.annotation.SuppressLint
import android.graphics.Color
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.moviewatchlist.databinding.ActivityMainBinding
import com.example.moviewatchlist.databinding.LayoutMovieItemBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var binding2: LayoutMovieItemBinding //ეს ცვლადი აქ არ გჭირდება


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding2 = LayoutMovieItemBinding.inflate(layoutInflater)
//        setContentView(binding2.root)
//        binding2 = LayoutMovieItemBinding.inflate(layoutInflater)
//        setContentView(binding2.root)

//        var redcolor: View? = findViewById(R.color.red)
//        var indicator:ImageView = findViewById(R.id.indicator)
//        var item:View? = findViewById(R.id.TW_taskName)




        binding.RVTodoList.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


//        binding2.indicator.setOnClickListener {
//
//            if (binding2.indicator.colorFilter == redcolor) {
//                binding2.indicator.isClickable = true
//                Toast.makeText(
//                    this@MainActivity,
//                    "${binding.ETEnterTask.text.toString()} mate",
//                    Toast.LENGTH_SHORT
//                ).show()
//
//            } else {
//                Toast.makeText(
//                    this@MainActivity,
//                    "${binding.ETEnterTask.text.toString()} completed",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
        // შეგიძლია ადაპტერს გადასცე ცარიელი სია პირდაპირ  mutableListOf<Todo>()

            binding.RVTodoList.adapter = MoviesAdapter(
                mutableListOf(
                    Todo(
                        ""
                    )
                )
            ).apply {

                binding.BTNAddbutton.setOnClickListener {

                    if (binding.ETEnterTask.text.isNotEmpty()) {
                        todoListList.add(Todo(binding.ETEnterTask.text.toString()))
                        notifyDataSetChanged()
                        Toast.makeText(
                            this@MainActivity,
                            "${binding.ETEnterTask.text.toString()} added",
                            Toast.LENGTH_SHORT
                        ).show()
                        binding.ETEnterTask.text.clear()


                    } else {
                        binding.ETEnterTask.hint = "please enter task to proceed"
                        binding.ETEnterTask.setHintTextColor(Color.RED)
                        binding.TWEnterTodo.setTextColor(Color.RED)
                    }

//                item?.setOnClickListener {
//                    if(indicator.colorFilter == redcolor){
//                        Toast.makeText(
//                            this@MainActivity,
//                            "witelia",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }else{
//                        Toast.makeText(
//                            this@MainActivity,
//                            "araa",
//                            Toast.LENGTH_SHORT
//                        ).show()
//                    }
//                }




                    setOnItemCLickListener { task: Todo, i: Int ->
                        todoListList.remove(task)
                        notifyItemChanged(0)
                        notifyItemRangeChanged(0, 5)

                        Toast.makeText(
                            this@MainActivity,
                            "${binding.ETEnterTask.text.toString()} completed",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    /* აქ რო არ გეწეროს ყველა კოდი შეგიძლია ადაპტერი გამოაცხადო ცალკე ცვლადად
                       val toDoAdapter = ToDoAdapter(mutableListOf<Todo>())

                       და მერე შეგიძლია სხვადასხვა მეთოდები დაამატო ადაპტერში მაგ. აითემისჩამატება

                      ან შენი დასეტილი adapter ის დათრევა შეგიძლია შემდეგნაირად

                      val todoAdapter = binding.recyclerView.adapter as TodoAdapter


                     */
                }

            }
    }
}





