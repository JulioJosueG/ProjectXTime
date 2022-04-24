package com.example.projectxtime.view.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.projectxtime.R
import com.example.projectxtime.databinding.FragmentAdminStudentsBinding

class AdminStudentsFragment : Fragment() {

    private lateinit var binding:FragmentAdminStudentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentAdminStudentsBinding.inflate(inflater, container,false)

        binding.btnFloatAdd.setOnClickListener {
            it.findNavController().navigate(R.id.action_adminStudentsFragment_to_addStudentFragment)
        }

        return inflater.inflate(R.layout.fragment_admin_students, container, false)
    }

}