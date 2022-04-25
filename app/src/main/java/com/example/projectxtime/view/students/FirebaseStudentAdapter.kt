package com.example.recyclerview

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectxtime.model.Course
import com.example.projectxtime.view.students.StudentScheduleFragment
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions

// FirebaseRecyclerAdapter is a class provided by
// FirebaseUI. it provides functions to bind, adapt and show
// database contents in a Recycler View
private class FirebaseStudentAdapter (
    val context: StudentScheduleFragment,
    private val userList : ArrayList<Course>)
    : RecyclerView.Adapter<FirebaseStudentAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            com.example.projectxtime.R.layout.student_schedule_rv_item,
            parent, false
        )
        return ViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentitem = userList[position]

        holder.courseName.text = currentitem.courseName
        holder.courseShcedule.text = currentitem.courseSchedule

    }

    override fun getItemCount(): Int {

        return userList.size
    }


    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val courseName : TextView = itemView.findViewById<TextView>(com.example.projectxtime.R.id.idTVCourse)
        val courseShcedule : TextView =itemView.findViewById<TextView>(com.example.projectxtime.R.id.idTVDate)

    }

}