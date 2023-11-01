package com.example.todo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.example.todo.TaskViewModel
import com.example.todo.databinding.AddTaskFragmentBinding
import com.example.todo.room.Task


class AddTaskFragment : Fragment() {
    private var _binding: AddTaskFragmentBinding? = null
    private val binding get() = _binding!!
    private val vm: TaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AddTaskFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addTaskBtn.setOnClickListener {
            if (binding.taskEdit.text.isNotEmpty()) {
                val task = Task(taskText = binding.taskEdit.text.toString())
                vm.insertTask(task)
            } else {
                Toast.makeText(context, "Invalid Input", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}