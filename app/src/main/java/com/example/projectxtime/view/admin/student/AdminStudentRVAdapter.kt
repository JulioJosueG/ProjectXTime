package com.example.projectxtime.view.admin.student

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectxtime.R
import com.example.projectxtime.view.admin.AdminStudentsFragment

public class AdminStudentRVAdapter (private val studentList: ArrayList<StudentsModel>)
    : RecyclerView.Adapter<AdminStudentRVAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.admin_students_rv_item, parent, false)
        return  ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentStudent = studentList[position]
        holder.tvMatricula.text = currentStudent.studentCode
        holder.tvNombre.text = currentStudent.name
        holder.tvApellido.text = currentStudent.lastName
        holder.TvSexo.text = currentStudent.gender
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val tvMatricula : TextView = itemView.findViewById(R.id.tv_matricula)
        val tvNombre : TextView = itemView.findViewById(R.id.tv_nombre)
        val tvApellido : TextView = itemView.findViewById(R.id.tv_apellido)
        val TvSexo : TextView = itemView.findViewById(R.id.tv_sexo)
    }
}