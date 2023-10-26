package com.example.todo.room

import androidx.lifecycle.LiveData
import com.example.todo.room.Task
import com.example.todo.room.TaskDao

class TaskRepository (private val taskDao: TaskDao) {

    var allTasks: LiveData<List<Task>> = taskDao.gelAllTasks()

    suspend fun insertTask(task: Task) { taskDao.insertTask(task) }

    fun updateTask(task: Task) { taskDao.updateTask(task) }

    fun deleteTask(task: Task) { taskDao.deleteTask(task) }
}