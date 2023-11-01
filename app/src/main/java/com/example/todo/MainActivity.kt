package com.example.todo


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.todo.databinding.ActivityMainBinding
import com.example.todo.fragments.AddTaskFragment
import com.example.todo.fragments.TaskListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var vm: TaskViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        vm = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(TaskViewModel::class.java)
        openFragment(TaskListFragment())
        binding.addButton.setOnClickListener { openFragment(AddTaskFragment()) }
    }

    private fun openFragment(fragment: Fragment) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit()
    }
}