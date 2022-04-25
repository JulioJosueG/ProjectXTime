package com.example.projectxtime.view.admin

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.projectxtime.R
import com.example.projectxtime.databinding.FragmentAddSubjectBinding
import com.example.projectxtime.model.Course
import com.example.projectxtime.teachers.Teacher
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import javax.security.auth.Subject

class AddSubject : Fragment() {
    lateinit var binding: FragmentAddSubjectBinding
    lateinit var dbreference: DatabaseReference

    private fun ValidarDatos() {
        // validate data

        if(TextUtils.isEmpty(binding.TxtNombre.text.toString())){
            binding.TxtNombre.error = "This field is required"
        }
        else if(TextUtils.isEmpty(binding.TxtCreditos.text.toString())){
            binding.TxtCreditos.error = "This field is required"
        }
        else if(TextUtils.isEmpty(binding.TxtCod.text.toString())){
            binding.TxtCod.error = "This field is required"
        }
        else{
            // data is valid, continue signup
            RegistrarAsignaturas()
        }
    }

    private fun RegistrarAsignaturas() {

        val idAsignatura = dbreference.push().key.toString()
        val Asignatura = Course(
            binding.TxtCod.text.toString(),
            binding.TxtNombre.text.toString(),
            binding.editTextDate.text.toString(),
            binding.TxtCreditos.text.toString())

        dbreference.child(idAsignatura).setValue(Asignatura).addOnSuccessListener{

        }
            .addOnFailureListener { e->
                Toast.makeText(requireContext(), "Database register failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dbreference = FirebaseDatabase.getInstance("https://projectxtime-d90c2-default-rtdb.firebaseio.com/").getReference("Subjects")

        binding = FragmentAddSubjectBinding.inflate(inflater,container,false)
        binding.button2.setOnClickListener{
            ValidarDatos()
        }
        return binding.root

    }

}