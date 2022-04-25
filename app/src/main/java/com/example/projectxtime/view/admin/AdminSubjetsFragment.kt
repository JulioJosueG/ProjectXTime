package com.example.projectxtime.view.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.projectxtime.R
import com.example.projectxtime.databinding.FragmentAdminStudentsBinding
import com.example.projectxtime.databinding.FragmentAdminSubjetsBinding

class AdminSubjetsFragment : Fragment() {

    private lateinit var binding: FragmentAdminSubjetsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAdminSubjetsBinding.inflate(inflater, container,false)

        binding.btnFloatAdd.setOnClickListener {
            it.findNavController().navigate(R.id.action_adminSubjetsFragment_to_addEditSubjectFragment)
        }
        return inflater.inflate(R.layout.fragment_admin_subjets, container, false)
    }
}
