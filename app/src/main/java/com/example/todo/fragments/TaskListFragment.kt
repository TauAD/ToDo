package com.example.todo.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.todo.TaskAdapter
import com.example.todo.TaskViewModel
import com.example.todo.databinding.TaskListFragmentBinding
import com.example.todo.room.Task


class TaskListFragment : Fragment() {

    private var _binding: TaskListFragmentBinding? = null
    private val binding get() = _binding!!
    private val model: TaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = TaskListFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = TaskAdapter()
        Log.d("TEST", "${model.allTasks.value}")
        model.allTasks.value?.let { adapter.setTasks(it) }
        binding.taskListView.adapter = adapter

        adapter.setOnItemClick(object : TaskAdapter.ListClickListener<Task> {
            override fun onClick(task: Task, position: Int) {
                //val intent = Intent(this@MainActivity, AddTaskActivity::class.java)
//                intent.putExtra("task", task)
//                startActivity(intent)
            }

            override fun onDelete(task: Task) { model.deleteTask(task) }
        })

//        model.allTasks.observe(this) {
//            adapter.setTasks(model.allTasks.value)
//            Log.d("TST", "${model.allTasks.value}")
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}