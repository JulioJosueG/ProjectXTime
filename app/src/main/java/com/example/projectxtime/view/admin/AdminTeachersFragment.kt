package com.example.projectxtime.view.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.projectxtime.R
import com.example.projectxtime.databinding.FragmentAddEditTeacherBinding
import com.example.projectxtime.databinding.FragmentAdminTeachersBinding
import com.example.projectxtime.databinding.FragmentLoginBinding


class AdminTeachersFragment : Fragment() {
    private lateinit var binding : FragmentAdminTeachersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminTeachersBinding.inflate(inflater,container,false)

        binding.btnAddTask.setOnClickListener{
            it.findNavController().navigate(R.id.action_adminTeachersFragment_to_addEditTeacherFragment)


        }
        return binding.root
    }

}