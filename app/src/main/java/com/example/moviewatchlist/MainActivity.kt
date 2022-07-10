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

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RVUsers.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

            binding.RVUsers.adapter = UsersAdapter(
                mutableListOf<User>()
            ).apply {

                binding.BTNAddbutton.setOnClickListener {

                    if (binding.ETEnterFirstname.text.isNotEmpty()) {

                        usersList.add(User(binding.ETEnterFirstname.text.toString()))
                        notifyDataSetChanged()
                        binding.ETEnterFirstname.text.clear()


                    } else {
                        binding.ETEnterFirstname.hint = "please enter user to proceed"
                        binding.ETEnterFirstname.setHintTextColor(Color.RED)
                        binding.TWEnterUser.setTextColor(Color.RED)
                    }

                    setOnItemCLickListener { user: User, i: Int ->
                        usersList.remove(user)
                        notifyItemChanged(0)
                        notifyItemRangeChanged(0, 5)

                        Toast.makeText(
                            this@MainActivity,
                            "${binding.ETEnterFirstname.text.toString()} deleted",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }

            }
    }
}





