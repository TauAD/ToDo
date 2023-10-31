package com.example.todo

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

import com.example.todo.databinding.TaskAddBinding
import com.example.todo.room.Task

class AddTaskActivity : AppCompatActivity() {
    lateinit var binding: TaskAddBinding
    lateinit var vm: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TaskAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vm = ViewModelProvider(
            this,
            ViewModelProvider
                .AndroidViewModelFactory
                .getInstance(application)
        ).get(TaskViewModel::class.java)

        binding.addTaskBtn.setOnClickListener {
            if (binding.taskEdit.text.isNotEmpty()) {
                val task = Task(taskText = binding.taskEdit.text.toString())
                vm.insertTask(task)
                this.finish()
            } else {
                Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show()
            }
        }
    }
}