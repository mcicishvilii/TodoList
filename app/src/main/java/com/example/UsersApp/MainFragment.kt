package com.example.UsersApp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.UsersApp.databinding.MainLayoutBinding

class MainFragment : Fragment() {
    private val usersAdapter by lazy { UsersAdapter() }

    private var _binding: MainLayoutBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MainLayoutBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }


    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()

    }


    private fun init(){

        binding.BTNAddbutton.setOnClickListener {
            setupRecycler()

            val firstName = binding.etFirstName.text.toString()
            val lastName = binding.etLastname.text.toString()
            val age = binding.etAge.text.toString()
            if (age.isEmpty()){
                Toast.makeText(requireContext(),"please enter the age",Toast.LENGTH_SHORT).show()
            }
            else{
                addUser(firstName, lastName, age)
            }

        }



        changeUser()
        removeUser()

        usersAdapter.submitList(usersList)
    }


    private fun addUser(firstName: String, lastName: String, age: String) {
        usersList.add(
            User(
                firstName,
                lastName,
                age.toInt()
            )
        )
    }

    private fun setupRecycler() {
        binding.rvUsers.apply {
            adapter = usersAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    private fun removeUser(){
        usersAdapter.apply {
            setOnDeleteClickListener { user, i ->

                binding.btnRefresh.setOnClickListener{
                    usersList.remove(user)
                    notifyItemRemoved(i)
                }
            }
        }
    }

    private fun changeUser(){
        usersAdapter.apply {
            setOnItemClickListener { user, i ->
                parentFragmentManager.beginTransaction().apply {
                    replace(R.id.flContent,ChangeFragment())
                    addToBackStack(ChangeFragment::javaClass.name)
                    commit()
                }
            }
        }
    }


}
