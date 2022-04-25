package com.example.projectxtime.view.admin

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectxtime.R
import com.example.projectxtime.databinding.FragmentAdminStudentsBinding
import com.example.projectxtime.view.admin.student.AdminStudentRVAdapter
import com.example.projectxtime.view.admin.student.StudentsModel
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class AdminStudentsFragment : Fragment() {

    private lateinit var binding:FragmentAdminStudentsBinding

    private lateinit var dbRef:DatabaseReference

    private lateinit var studentsRV: RecyclerView

    private lateinit var studentList: ArrayList<StudentsModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAdminStudentsBinding.inflate(inflater, container,false)

        binding.btnFloatAdd.setOnClickListener {
            it.findNavController().navigate(R.id.action_adminStudentsFragment_to_addStudentFragment)
        }

        //loading students
        studentsRV = binding.rvStudentsList
        studentsRV.layoutManager = LinearLayoutManager(requireContext())
        studentsRV.setHasFixedSize(true)

        studentList = arrayListOf<StudentsModel>()

        getStudentsData()

        return binding.root
    }

    private fun getStudentsData() {

        studentsRV.visibility = View.GONE

        dbRef = FirebaseDatabase.getInstance("https://projectxtime-d90c2-default-rtdb.firebaseio.com/").getReference("Students")

        dbRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                studentList.clear()
                if (snapshot.exists()){
                    for (studSnap in snapshot.children){
                        val studentData = studSnap.getValue(StudentsModel::class.java)
                        studentList.add(studentData!!)
                    }
                    val sAdapter = AdminStudentRVAdapter(studentList)
                    studentsRV.adapter = sAdapter

                    studentsRV.visibility = View.VISIBLE

                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(requireContext(), "Ocurrió un error obteniendo los estudiantes.", Toast.LENGTH_SHORT).show()
            }

        })
    }

}