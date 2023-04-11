package com.example.todo

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.DialogFragment

class DeleteTaskDialogFragment : DialogFragment() {
    private var editable: Editable? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        editable = context as Editable
        Log.d("test", "in DeleteTaskDialogFragment")
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val position = requireArguments().getInt("position")
        Log.d("test", "onCreateDialog, Position = $position")

        val builder = AlertDialog.Builder(getActivity())
        return builder
            .setTitle("Удалить заметку")
            .setMessage("Для удаления заметки нажмите ОК")
            .setPositiveButton("OK") { dialog, which -> editable?.deleteTask(position)}
            .setNegativeButton("Отмена", null)
            .create()
    }
}