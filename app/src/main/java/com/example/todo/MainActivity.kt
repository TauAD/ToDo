package com.example.todo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TaskAdapter

    private var tasksBase = mutableListOf(
        Task("Задача №1", "нет"),
        Task("Задача №2", "нет"),
        Task("Задача №3", "нет"),
        Task("Задача №4", "нет"),
        Task("Задача №5", "нет"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.taskListView.layoutManager = LinearLayoutManager(this)
        binding.taskListView.adapter = TaskAdapter(tasksBase, this)

        binding.addButton.setOnClickListener {
            val dialog = AddTaskDialogFragment()
            dialog.show(supportFragmentManager, "custom")
        }

        Log.d("test", "in onCreate")
    }

}