package com.example.todo

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView


class TaskAdapter(private val tasks: MutableList<Task>, private val context: Context): RecyclerView.Adapter<TaskAdapter.MyViewHolder>(), Editable {
    var pos: Int = 0

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textviewTask: TextView = itemView.findViewById(R.id.taskText)
        val buttonDeleteTask: ImageButton = itemView.findViewById(R.id.deleteButton)
        //val check_Task: CheckBox = itemView.findViewById(R.id.taskCheck)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.task_item, parent, false)
        Log.d("test", "in onCreateViewHolder")
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        pos = position
        val dialog = DeleteTaskDialogFragment()
        Log.d("test", "in onBindViewHolder")

        holder.textviewTask.text = tasks[position].taskText
        holder.buttonDeleteTask.setOnClickListener {
            dialog.show((context as AppCompatActivity).supportFragmentManager, "custom")
        }
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun deleteTask() {
        tasks.removeAt(this.pos)
        notifyDataSetChanged()
    }

    override fun addTask(task: String) {
        tasks.add(Task(task, "нет"))
    }

}