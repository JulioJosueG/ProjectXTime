package com.example.projectxtime.view.students

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projectxtime.databinding.FragmentStudentScheduleBinding
import com.example.projectxtime.model.Course
import com.example.projectxtime.viewmodel.StudentViewModel

import com.google.firebase.database.*

class StudentScheduleFragment : Fragment() {
private lateinit var binding: FragmentStudentScheduleBinding
    private lateinit var viewModel : StudentViewModel
    lateinit var dbreference: DatabaseReference
    private lateinit var CourseArray : ArrayList<Course>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStudentScheduleBinding.inflate(inflater,container,false)
        binding.rvSchedule.layoutManager = LinearLayoutManager(context)
        binding.rvSchedule.setHasFixedSize(true)
        CourseArray = arrayListOf<Course>()

        dbreference = FirebaseDatabase.getInstance("https://projectxtime-d90c2-default-rtdb.firebaseio.com/").getReference("Subjects")

        dbreference.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {

                    for (userSnapshot in snapshot.children) {


                        val course = userSnapshot.getValue(Course::class.java)
                        CourseArray.add(course!!)

                    }

                    binding.rvSchedule.adapter =StudentRVAdapter(this,CourseArray)


                }

            }

            override fun onCancelled(error: DatabaseError) {
            }
        })

        return binding.root

    }

}