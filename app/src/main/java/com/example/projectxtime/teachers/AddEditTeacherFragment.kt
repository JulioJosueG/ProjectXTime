package com.example.projectxtime.teachers

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.projectxtime.R
import com.example.projectxtime.databinding.FragmentAddEditTeacherBinding
import com.example.projectxtime.databinding.FragmentAdminTeachersBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddEditTeacherFragment : Fragment() {

    private lateinit var binding : FragmentAddEditTeacherBinding

    private lateinit var database : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    private fun ValidateData() {
        // validate data

        if(TextUtils.isEmpty(binding.teacherNameEdit.text.toString())){
            binding.teacherNameEdit.error = "This field is required"
        }
        else if(TextUtils.isEmpty(binding.teacherLastNameEdit.text.toString())){
            binding.teacherLastNameEdit.error = "This field is required"
        }
        else{
            // data is valid, continue signup
            registateTeacher()
        }
    }

    private fun registateTeacher() {

        var gender : String ?= null;
        if (binding.rbMen.isChecked){
            gender = "Hombre"
        }
        else {
            gender = "Mujer"
        }

        val teacherID = database.push().key.toString()
        val teacher = Teacher(teacherID,
        binding.teacherLastNameEdit.text.toString(),
        binding.teacherLastNameEdit.text.toString(),
        gender)

        database.child(teacherID).setValue(teacher).addOnSuccessListener{

        }
        .addOnFailureListener { e->
            // database user add failed
            Toast.makeText(requireContext(), "Database register failed due to ${e.message}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddEditTeacherBinding.inflate(inflater,container,false)
        // init database
        database = FirebaseDatabase.getInstance("https://projectxtime-d90c2-default-rtdb.firebaseio.com/").getReference("Teachers")

        binding.btnAddUpdate.setOnClickListener{
            ValidateData()

        }
        return binding.root
    }
}