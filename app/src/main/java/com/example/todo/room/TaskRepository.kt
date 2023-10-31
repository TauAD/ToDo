package com.example.todo.room

import androidx.lifecycle.LiveData

class TaskRepository (private val taskDao: TaskDao) {
    var allTasks: LiveData<List<Task>> = taskDao.gelAllTasks()
    suspend fun insertTask(task: Task) { taskDao.insertTask(task) }
    suspend fun updateTask(task: Task) { taskDao.updateTask(task) }
    suspend fun deleteTask(task: Task) { taskDao.deleteTask(task) }
}