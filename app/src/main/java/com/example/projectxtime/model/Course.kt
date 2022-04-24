
package com.example.projectxtime.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "CourseTable")
data class Course
    (@PrimaryKey @ColumnInfo(name = "courseCode")val courseCode :String,
     @ColumnInfo(name = "name")val courseName :String,
     @ColumnInfo(name = "teacherId")val courseTeacherId : String,
     @ColumnInfo(name = "schedule")val courseSchedule :String){
}