package com.example.projectxtime.view.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.projectxtime.R
import com.example.projectxtime.databinding.FragmentActivatePeriodBinding

class ActivatePeriodFragment : Fragment() {

    private lateinit var binding: FragmentActivatePeriodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentActivatePeriodBinding.inflate(inflater,container,false)

        binding.btnActivate.setOnClickListener {
            it.findNavController().navigate(R.id.action_adminMenuFragment_to_adminScoreFragment)
        }

        return inflater.inflate(R.layout.fragment_activate_period, container, false)
    }

}