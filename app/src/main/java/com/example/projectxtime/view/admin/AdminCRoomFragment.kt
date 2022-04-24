package com.example.projectxtime.view.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.projectxtime.R
import com.example.projectxtime.databinding.FragmentAddCRoomBinding
import com.example.projectxtime.databinding.FragmentAdminCRoomBinding


class AdminCRoomFragment : Fragment() {

    private lateinit var binding: FragmentAdminCRoomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentAdminCRoomBinding.inflate(inflater, container, false)

//        binding.btnAdd.setOnClickListener {
//            it.findNavController().navigate(R.id.action_adminCRoomFragment_to_addCRoomFragment)
//        }

        return binding.root
    }


}