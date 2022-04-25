package com.example.projectxtime.view.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.projectxtime.R
import com.example.projectxtime.databinding.FragmentAdminScoreBinding

class AdminScoreFragment : Fragment() {

    private lateinit var binding: FragmentAdminScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAdminScoreBinding.inflate(inflater,container,false)

        binding.btnPeriodo.setOnClickListener {
            it.findNavController().navigate(R.id.action_adminScoreStudentFragment_to_activatePeriodFragment)
        }

        binding.btnScore.setOnClickListener {
            it.findNavController().navigate(R.id.action_adminScoreStudentFragment_to_manageScoreFragment)

        }

        return binding.root
    }

}