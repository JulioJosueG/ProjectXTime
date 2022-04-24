package com.example.projectxtime.model

import androidx.room.*


@Entity(tableName = "TeacherTable")
data class Teacher
    (@PrimaryKey @ColumnInfo(name = "teacherid")val teacherid :String,
     @ColumnInfo(name = "name")val studentName :String,
     @ColumnInfo(name = "lastName")val studentLastName : String)



@Entity(primaryKeys = ["teacherid", "courseCode"], tableName = "teacherCourseTable")
data class TeachersCourse(
    val teacherId: String,
    val courseCode: String
)

@Entity(tableName = "TeacherWithCourseTable")
data class TeacherWithCourse(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "teacherid",
        entityColumn = "courseCode",
        associateBy = Junction(TeachersCourse::class)
    )
    val course: List<Course>
)