package com.example.projectxtime.view.admin.subjects

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.projectxtime.R
import com.example.projectxtime.databinding.FragmentAddEditSubjectBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddEditSubjectFragment : Fragment() {

    private lateinit var binding: FragmentAddEditSubjectBinding

    private lateinit var auth: FirebaseAuth
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddEditSubjectBinding.inflate(inflater,container,false)

        return binding.root

        validarData()
    }

    private fun validarData() {
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

        //get current user uid
        val uid = auth.currentUser?.uid


        val idAsignatura = dbRef.push().key.toString()
        val Asignatura = Subject(idAsignatura,
            binding.TxtCod.text.toString(),
            binding.TxtNombre.text.toString(),
            binding.TxtCreditos.text.toString())

        dbRef = FirebaseDatabase.getInstance().getReference("Subjects")
        dbRef.child(uid!!)
            .setValue(Asignatura)
            .addOnSuccessListener {
                Toast.makeText(requireContext(), "Estdiante creado...", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener{e->
                Toast.makeText(requireContext(), "Failed saving user info due to ${e.message}", Toast.LENGTH_SHORT).show()
            }

    }

}