package com.example.projectxtime.view.students

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectxtime.databinding.FragmentStudentScheduleBinding
import com.example.projectxtime.viewmodel.StudentViewModel

class StudentScheduleFragment : Fragment() {
private lateinit var binding: FragmentStudentScheduleBinding
    private lateinit var viewModel : StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentScheduleBinding.inflate(inflater,container,false)
        binding.rvSchedule.layoutManager = LinearLayoutManager(context)

        val taskRVAdapter = StudentRVAdapter(this)
        binding.rvSchedule.adapter = taskRVAdapter


        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(requireNotNull(this.activity).application)
        )[StudentViewModel::class.java]



        viewModel.allStudent.observe(viewLifecycleOwner, Observer { list ->
            list?.let {
                taskRVAdapter.updateList(it)
            }
        })


        return binding.root
    }

}