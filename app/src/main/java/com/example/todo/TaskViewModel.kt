package com.example.todo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.todo.room.AppDatabase
import com.example.todo.room.Task
import com.example.todo.room.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel (application: Application) : AndroidViewModel(application) {

    private val repo: TaskRepository
    var allTasks: LiveData<List<Task>>

    init {
        val taskDao = AppDatabase.getInstance(application)?.taskDao()
        repo = TaskRepository(taskDao!!)
        allTasks = repo.allTasks
    }

    fun insertTask(task: Task) = viewModelScope.launch { repo.insertTask(task) }
    fun deleteTask(task: Task) = viewModelScope.launch { repo.deleteTask(task) }
    fun updateTask(task: Task) = viewModelScope.launch { repo.updateTask(task) }
}