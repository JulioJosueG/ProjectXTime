package com.example.projectxtime.view.students


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectxtime.R
import com.example.projectxtime.model.Course
import com.example.projectxtime.model.StudentWithCourse
import com.google.firebase.database.ValueEventListener

class StudentRVAdapter(
    val context: ValueEventListener,
    private val userList: ArrayList<Course>)
    : RecyclerView.Adapter<StudentRVAdapter.ViewHolder>() {


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

        val courseName : TextView = itemView.findViewById(R.id.idTVCourse)
        val courseShcedule : TextView =itemView.findViewById(R.id.idTVDate)

    }

}
