package com.example.projectxtime.view.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.projectxtime.R
import com.example.projectxtime.databinding.FragmentAddStudentBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddStudentFragment : Fragment() {

    private lateinit var binding: FragmentAddStudentBinding

    //Firebase
    private  lateinit var auth:FirebaseAuth
    private lateinit var dbRef:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddStudentBinding.inflate(inflater,container,false)

        //init firebase auth

        binding.btnSave.setOnClickListener {
            validar()
        }

        return binding.root
    }

    private var matricula = ""
    private var nombre = ""
    private var apellido = ""
    private var sexo = ""

    private fun validar() {


        matricula = binding.etmatricula.text.toString()
        nombre = binding.etNombre.text.toString()
        apellido = binding.etApellidos.text.toString()

        if (binding.rbMen.isChecked){
            sexo = "Hombre"
        }else if (binding.rbWomen.isChecked){
            sexo = "Mujer"
        }

        if(nombre == ""){

            Toast.makeText(requireContext(), "El nombre requerido...", Toast.LENGTH_SHORT).show()
        }
        else if(apellido == ""){
            Toast.makeText(requireContext(), "El apellido es requerido...", Toast.LENGTH_SHORT).show()
        }
        else if(sexo == ""){
            Toast.makeText(requireContext(), "El sexo es requerido...", Toast.LENGTH_SHORT).show()
        }
        else{
            sent()
        }

    }

    private fun sent() {

        //get current user uid

        val hashMap = HashMap<String, Any?>()
        hashMap.put("matricula",matricula)
        hashMap.put("nombre",nombre)
        hashMap.put("apellido",apellido)
        hashMap.put("sexo",sexo)
        dbRef = FirebaseDatabase.getInstance("https://projectxtime-d90c2-default-rtdb.firebaseio.com/").getReference("Students")
        val teacherID = dbRef.push().key.toString()
        dbRef.child(teacherID)
            .setValue(hashMap)
            .addOnSuccessListener {
                Toast.makeText(requireContext(), "Estdiante creado...", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener{e->
                Toast.makeText(requireContext(), "Failed saving user info due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

}