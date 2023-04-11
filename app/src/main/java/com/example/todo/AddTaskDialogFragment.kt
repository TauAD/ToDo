package com.example.todo

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.fragment.app.DialogFragment

class AddTaskDialogFragment : DialogFragment() {
    private var editable: Editable? = null

   override fun onAttach(context: Context) {
       super.onAttach(context)
        editable = context as Editable
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val userInput = EditText(context)
        val builder = AlertDialog.Builder(getActivity())
        Log.d("test", "in onCreateDialog of AddTaskDialogFragment")

        return builder
            .setTitle("Введите заметку")
            .setMessage("Для закрытия окна нажмите ОК")
            .setPositiveButton("OK") { dialog, which -> editable?.addTask(userInput.text.toString())}
            .setNegativeButton("Отмена", null)
            .setView(userInput).create()
    }
}

