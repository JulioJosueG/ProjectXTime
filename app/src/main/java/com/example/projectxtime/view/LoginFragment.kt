package com.example.projectxtime.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import com.example.projectxtime.R
import com.example.projectxtime.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)


        binding.btnLogin.setOnClickListener{
            if (binding.usertxt.text.contentEquals("admin") &&binding.usertxt.text.contentEquals("admin")){
                it.findNavController().navigate(R.id.action_loginFragment_to_adminMenuFragment)

            }
            if (binding.usertxt.text.contentEquals("student") &&binding.usertxt.text.contentEquals("student")){
                it.findNavController().navigate(R.id.action_loginFragment_to_studentMenuFragment)

            }

            if (binding.usertxt.text.contentEquals("teacher") &&binding.usertxt.text.contentEquals("teacher")){
                it.findNavController().navigate(R.id.action_loginFragment_to_teacherMenuFragment)

            }


        }

        return binding.root
    }



}