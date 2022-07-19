package com.example.UsersApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.UsersApp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val usersAdapter by lazy { UsersAdapter() }

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()

    }




    private fun init(){
        binding.BTNAddbutton.setOnClickListener {
            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastname.text.toString()

            setupRecycler()
            addUser(firstName, lastName)
            usersAdapter.submitList(usersList)
        }

    }

    private fun addUser(firstName: String, lastName: String) {
        usersList.add(
            User(
                firstName,
                lastName
            )
        )
    }

    private fun setupRecycler() {
        binding.rvUsers.apply {
            adapter = usersAdapter
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }
        usersAdapter.submitList(usersList)
    }

    private fun removeUser(){

    }
}





