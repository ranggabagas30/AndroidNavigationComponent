package com.excercise.androidnavigationcomponent.dialog


import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.DialogFragment

import com.excercise.androidnavigationcomponent.R

/**
 * A simple [Fragment] subclass.
 */
class MyDialogFragment : DialogFragment() {

    private lateinit var editText: EditText

    companion object {
        fun newInstance(title: String): MyDialogFragment {
            val fragment = MyDialogFragment()
            val args = Bundle()
            args.putString("title", title)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_my_dialog, container)
        return activity!!.layoutInflater.inflate(R.layout.fragment_my_dialog, container) // to use theme
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editText = view.findViewById(R.id.txt_your_name)
        val title = arguments?.getString("title")
        dialog?.setTitle(title)
    }
}
