package com.example.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.TaskItemBinding
import com.example.todo.room.Task

class TaskAdapter: RecyclerView.Adapter<TaskAdapter.MyViewHolder>() {

    var taskList = mutableListOf<Task>()
    var clickListener: ListClickListener<Task>? = null

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = TaskItemBinding.bind(itemView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.task_item, parent, false)

        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val task = taskList[position]

        holder.binding.run {
            taskText.text = task.taskText

            layout.setOnClickListener { clickListener?.onClick(task, position) }

            deleteButton.setOnClickListener { clickListener?.onDelete(task) }
        }
    }
    override fun getItemCount(): Int { return taskList.size }

    fun setOnItemClick(listClickListener: ListClickListener<Task>) {
        this.clickListener = listClickListener
    }

    interface ListClickListener<T> {
        fun onClick(task: T, position: Int)
        fun onDelete(task: T)
    }

    fun setTasks(tasks: List<Task>?) {
        taskList = tasks?.toMutableList()!!
        notifyDataSetChanged()
    }
}