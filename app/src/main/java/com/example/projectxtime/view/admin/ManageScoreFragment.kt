package com.example.projectxtime.view.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.projectxtime.R
import com.example.projectxtime.databinding.FragmentManageScoreBinding

class ManageScoreFragment : Fragment() {

    private lateinit var binding: FragmentManageScoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentManageScoreBinding.inflate(inflater,container,false)

//        binding.rvStudentForScore.setOnClickListener {
//            it.findNavController().navigate(R.id.action_manageScoreFragment_to_adminScoreStudentFragment)
//        }

        return inflater.inflate(R.layout.fragment_manage_score, container, false)
    }

}