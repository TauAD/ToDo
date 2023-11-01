package com.example.todo.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todo.TaskAdapter
import com.example.todo.TaskViewModel
import com.example.todo.databinding.TaskListFragmentBinding
import com.example.todo.room.Task

class TaskListFragment : Fragment() {
    private var _binding: TaskListFragmentBinding? = null
    private val binding get() = _binding!!
    private val vm: TaskViewModel by activityViewModels()
    val TAG = "TASK_LIST_FRAG"

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d(TAG, "onCreateView")
        _binding = TaskListFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = TaskAdapter()
        binding.taskListView.layoutManager = LinearLayoutManager(activity)
        binding.taskListView.adapter = adapter
        vm.allTasks.value?.let { adapter.setTasks(it) }
        Log.d(TAG, "nViewCreated")

        adapter.setOnItemClick(object : TaskAdapter.ListClickListener<Task> {
            override fun onClick(task: Task, position: Int) {
                //val intent = Intent(this@MainActivity, AddTaskActivity::class.java)
//                intent.putExtra("task", task)
//                startActivity(intent)
            }
            override fun onDelete(task: Task) { vm.deleteTask(task) }
        })

        activity?.let {
            vm.allTasks.observe(it) { adapter.setTasks(vm.allTasks.value) }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}