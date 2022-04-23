package com.example.projectxtime.view.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.projectxtime.R
import com.example.projectxtime.databinding.FragmentAdminMenuBinding


class AdminMenuFragment : Fragment() {

    private lateinit var binding: FragmentAdminMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminMenuBinding.inflate(inflater,container,false)

        binding.btnDocentes.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_teacherMenuFragment)
        }

        binding.btnStudent.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginFragment_to_studentMenuFragment)
        }

        binding.btnAsignaturas.setOnClickListener {
            //it.findNavController().navigate(R.id.ac)
        }

        return inflater.inflate(R.layout.fragment_admin_menu, container, false)
    }

}