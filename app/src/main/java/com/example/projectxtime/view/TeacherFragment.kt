package com.example.projectxtime.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projectxtime.R
import com.example.projectxtime.databinding.FragmentTeacherMenuBinding
import com.example.projectxtime.model.Teacher
import com.google.firebase.database.FirebaseDatabase

class TeacherFragment : AppCompatActivity() {


    lateinit var editP1: EditText
    lateinit var editP2: EditText
    lateinit var PR1: EditText
    lateinit var PRF: EditText
    lateinit var Final: EditText
    lateinit var  ButtonSave : Button

    fun OnCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
    setContentView(R.layout.teacher_fragment)
        editP1 = findViewById(R.id.primerparcial)
        editP2 = findViewById(R.id.segundoparcial)
        PR1 = findViewById(R.id.practica1)
        PRF = findViewById(R.id.Practica2)
        Final = findViewById(R.id.Final)

        ButtonSave.setOnClickListener{
         /*   saveTeacher() */
        }

    }

    private fun saveTeacher(){
        /*

        val parcial1 = editTextName.text.toString().trim()
        val parcial2 = editTextLastName.text.toString().trim()
        val practica1 = editTextEmail.text.toString().trim()
        val practica2 = editTextTelefono.text.toString().trim()
        val final = editTextTelefono.text.toString().trim()

        if (name.isEmpty()){
            editTextName.error = "Inserte un nombre porfavor"
            return
        }
        if (lastname.isEmpty()){
            editTextLastName.error = "Inserte un Apellido porfavor"
            return
        }
        if (email.isEmpty()){
            editTextEmail.error = "Inserte un Correo porfavor"
            return
        }
        if (phone.isEmpty()){
            editTextTelefono.error = "Inserte un numero de telefono porfavor"
            return
        }
        val ref = FirebaseDatabase.getInstance().getReference("teacher")

        val teacherid = ref.push().key */




    }

    }