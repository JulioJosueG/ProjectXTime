package com.example.projectxtime.view.students


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projectxtime.R
import com.example.projectxtime.model.StudentWithCourse

class StudentRVAdapter(
    val context: StudentScheduleFragment,
) :
    RecyclerView.Adapter<StudentRVAdapter.ViewHolder>() {

    private val allStudent = ArrayList<StudentWithCourse>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseTV = itemView.findViewById<TextView>(R.id.idTVCourse)
        val dateTV = itemView.findViewById<TextView>(R.id.idTVDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.student_schedule_rv_item,
            parent, false
        )
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.courseTV.setText(allStudent.get(position).course.get(position).courseName)
        holder.dateTV.setText("Horario : "+allStudent.get(position).course.get(position).courseSchedule)

    }
    override fun getItemCount(): Int {
        return allStudent.size
    }
    fun updateList(newList: List<StudentWithCourse>) {
        allStudent.clear()
        allStudent.addAll(newList)
        notifyDataSetChanged()
    }

}
