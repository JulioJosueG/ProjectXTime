package com.example.projectxtime

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.projectxtime.databinding.FragmentAddStudentBinding
import com.example.projectxtime.databinding.FragmentAddSubjetsBinding
import com.example.projectxtime.teachers.Teacher
import com.google.firebase.database.DatabaseReference


class AddSubjects : Fragment() {

    lateinit var binding: FragmentAddSubjetsBinding
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
        val Asignatura = Teacher(idAsignatura,
            binding.TxtCod.text.toString(),
            binding.TxtNombre.text.toString(),
            binding.TxtCreditos.text.toString())

        dbreference.child(idAsignatura).setValue(Asignatura).addOnSuccessListener{

        }
            .addOnFailureListener { e->-
                // database user add failed
                Toast.makeText(requireContext(), "Database register failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddSubjetsBinding.inflate(inflater,container,false)
        ValidarDatos()
        return binding.root

    }

}