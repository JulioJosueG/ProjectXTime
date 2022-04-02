package com.example.projectxtime.model

import androidx.room.*


@Entity(tableName = "studentTable")
data class Student
    (@PrimaryKey @ColumnInfo(name = "studentMatricula")val studentMatricula :String,
     @ColumnInfo(name = "name")val studentName :String,
     @ColumnInfo(name = "lastName")val studentLastName : String)



@Entity(primaryKeys = ["studentMatricula", "courseCode"], tableName = "studentCourseTable")
data class StudentCourse(
    val studentMatricula: String,
    val courseCode: String
)

@Entity(tableName = "StudentWithCourseTable")
data class StudentWithCourse(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentMatricula",
        entityColumn = "courseCode",
        associateBy = Junction(StudentCourse::class)
    )
    val course: List<Course>
)