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
        auth = FirebaseAuth.getInstance()

        binding.btnSave.setOnClickListener {
            validar()
        }

        return inflater.inflate(R.layout.fragment_add_student, container, false)
    }

    private var matricula = ""
    private var nombre = ""
    private var apellido = ""
    private var sexo = ""

    private fun validar() {

        val  uid =

        matricula = binding.etMatricula.text.toString()
        nombre = binding.etName.text.toString()
        apellido = binding.etLastName.text.toString()

        if (binding.rbMen.isChecked){
            sexo = "Hombre"
        }else if (binding.rbWomen.isChecked){
            sexo = "Mujer"
        }

        if(nombre == ""){
            Toast.makeText(this, "El nombre requerido...", Toast.LENGTH_SHORT).show()
        }
        else if(apellido == ""){
            Toast.makeText(this, "El apellido es requerido...", Toast.LENGTH_SHORT).show()
        }
        else if(sexo == ""){
            Toast.makeText(this, "El sexo es requerido...", Toast.LENGTH_SHORT).show()
        }
        else{
            sent()
        }

    }

    private fun sent() {

        //get current user uid
        val uid = auth.currentUser?.uid

        val hashMap = HashMap<String, Any?>()
        hashMap.put("matricula",matricula)
        hashMap.put("nombre",nombre)
        hashMap.put("apellido",apellido)
        hashMap.put("sexo",sexo)

        dbRef = FirebaseDatabase.getInstance().getReference("Students")
        dbRef.child(uid!!)
            .setValue(hashMap)
            .addOnSuccessListener {
                Toast.makeText(this, "Estdiante creado...", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener{e->
                Toast.makeText(this, "Failed saving user info due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

}