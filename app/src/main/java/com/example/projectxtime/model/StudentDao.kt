package com.example.projectxtime.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(Student: Student)

    @Update
    suspend fun update(Student: Student)

    @Delete
    suspend fun delete(Student: Student)

    @Query("Select * from studentTable order by studentMatricula ASC")
    fun getAllStudents(): LiveData<List<Student>>

    @Transaction
    @Query("SELECT * FROM studentTable")
    fun getStudentsWithCourse(): LiveData<List<StudentWithCourse>>

}