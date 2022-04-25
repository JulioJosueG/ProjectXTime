package com.example.projectxtime.view.admin

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.projectxtime.R
import com.example.projectxtime.databinding.FragmentAddCRoomBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class AddCRoomFragment : Fragment() {

    lateinit var dbreference: DatabaseReference
private lateinit var binding: FragmentAddCRoomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddCRoomBinding.inflate(inflater,container,false)


        binding.btnGuardar.setOnClickListener {

            addCourse()
        }
        // Inflate the layout for this fragment
        return binding.root
    }

private fun addCourse() {
    val map = mapOf(
        "Codigo" to binding.courseCodigo.text.toString(),
        "NombreCurso" to binding.courseNombre.text.toString(),
        "CapacidadCurso" to binding.courseCapacidad.text.toString()
    )
    //if(binding.courseCapacidad.text.isNullOrEmpty() || binding.courseCodigo.text.isNullOrEmpty() || binding.courseNombre.text.isNullOrEmpty()){
    //  Toast.makeText(requireContext(), "Debe llenar todos los campos", Toast.LENGTH_SHORT).show()
    //}
    dbreference = FirebaseDatabase.getInstance("https://projectxtime-d90c2-default-rtdb.firebaseio.com/").getReference("Courses")

    var id = dbreference.push().key.toString()
    dbreference.child(id).setValue(map).addOnCompleteListener {
        if (it.isSuccessful) {
            Toast.makeText(requireContext(), "Course Created", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(requireContext(), "It cant be Register", Toast.LENGTH_SHORT).show()

        }

    }

}


}