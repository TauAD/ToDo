package com.example.todo.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "tasks_table")
data class Task(
    @PrimaryKey(autoGenerate = true) var Id: Int? = null,
    @ColumnInfo(name = "text") var taskText: String
    ) : Serializable
