package com.example.projectxtime.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.projectxtime.R
import com.example.projectxtime.databinding.FragmentLoginBinding
import com.example.projectxtime.databinding.FragmentTeacherMenuBinding


class TeacherMenuFragment : Fragment() {
    private lateinit var binding: FragmentTeacherMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeacherMenuBinding.inflate(inflater,container,false)

        binding.imgSchedule.setOnClickListener{
            it.findNavController().navigate(R.id.action_teacherMenuFragment_to_studentScheduleFragment)

        }

        return binding.root

    }


}