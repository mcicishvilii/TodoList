package com.example.UsersApp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.UsersApp.databinding.FragmentChangeBinding


class ChangeFragment : Fragment()
{
    private val usersAdapter by lazy { UsersAdapter() }


    private var _binding: FragmentChangeBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        _binding = FragmentChangeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()




    }

    override fun onDestroyView()
    {
        _binding = null
        super.onDestroyView()

    }

    private fun setUpRecyclerView()
    {
        val name = binding.etName.text.toString()
        val lastName = binding.etLastName.text.toString()

        binding.btnChange.setOnClickListener {
            returnBack()
        }
    }



    private fun returnBack(){
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.flContent,MainFragment())
            addToBackStack(MainFragment::javaClass.name)
            commit()
        }
    }

}
