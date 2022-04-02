package com.example.projectxtime.viewmodel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.projectxtime.model.*

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

public class StudentViewModel(application: Application) : AndroidViewModel(application) {
    val allStudent :LiveData<List<StudentWithCourse>>
    private val repository: ProjectRepository


    init {
        val dao = ProjectDB.getDatabase(application).getStudentDao()
        repository = ProjectRepository(dao)
        allStudent = repository.allStudent
    }

    fun deleteStudent(student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(student)
    }

    fun updatedStudent(student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.update(student)
    }

    fun addStudent(student: Student) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(student)
    }
}