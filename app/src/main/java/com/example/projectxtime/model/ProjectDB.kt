package com.example.projectxtime.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities =  [Course::class , Student::class,  StudentCourse::class] , version = 1, exportSchema = false)
abstract class ProjectDB : RoomDatabase() {

    abstract fun getStudentDao(): StudentDao

    companion object {
        @Volatile
        private var INSTANCE: ProjectDB? = null

        fun getDatabase(context: Context): ProjectDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProjectDB::class.java,
                    "project_database"
                ).build()
                INSTANCE = instance

                instance
            }
        }
    }


}