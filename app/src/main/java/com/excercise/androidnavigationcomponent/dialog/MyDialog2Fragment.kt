package com.excercise.androidnavigationcomponent.dialog


import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.excercise.androidnavigationcomponent.R

/**
 * A simple [Fragment] subclass.
 */
class MyDialog2Fragment : DialogFragment(){

    private var onChooseDialogButtonListener: OnChooseDialogButtonListener? = null

    companion object{
        fun newInstance(title: String): MyDialog2Fragment {
            val fragment = MyDialog2Fragment()
            val args = Bundle()
            args.putString("title", title)
            fragment.arguments = args
            return fragment
        }
    }

    fun setOnChooseDialogButtonListener(onChooseDialogButtonListener: OnChooseDialogButtonListener) {
        this.onChooseDialogButtonListener = onChooseDialogButtonListener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val title = arguments!!.getString("title")
        val alertDialogBuilder = AlertDialog.Builder(context!!)
        alertDialogBuilder.setTitle(title)
        alertDialogBuilder.setMessage("Are you sure?")
        alertDialogBuilder.setPositiveButton("OK") { dialog, which ->
            onChooseDialogButtonListener?.onChooseDialogButton("OK")
        }
        alertDialogBuilder.setNegativeButton("Cancel") { dialog, which ->
            dismiss()
            onChooseDialogButtonListener?.onChooseDialogButton("Cancel")
        }
        return alertDialogBuilder.create()
    }

    interface OnChooseDialogButtonListener {
        fun onChooseDialogButton(option: String)
    }
}
