package com.example.projectxtime.model

import androidx.lifecycle.LiveData

class ProjectRepository(private val studentDao: StudentDao) {

    val allStudent: LiveData<List<StudentWithCourse>> = studentDao.getStudentsWithCourse()

    suspend fun insert(student: Student) {
        studentDao.insert(student)
    }
    suspend fun delete(student: Student){
        studentDao.delete(student)
    }

    suspend fun update(student: Student){
        studentDao.update(student)
    }
}