package com.example.UsersApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.GridLayoutManager
import com.example.UsersApp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val usersAdapter by lazy { UsersAdapter() }
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flContent,MainFragment())
            addToBackStack(MainFragment::javaClass.name)
            commit()
        }

        supportFragmentManager.findFragmentById(R.id.mainFragment)
    }







}





