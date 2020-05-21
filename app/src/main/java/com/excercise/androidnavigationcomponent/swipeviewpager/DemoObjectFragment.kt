package com.excercise.androidnavigationcomponent.swipeviewpager


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.excercise.androidnavigationcomponent.R
import kotlinx.android.synthetic.main.fragment_demo_object.*

/**
 * A simple [Fragment] subclass.
 */
class DemoObjectFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_demo_object, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ARG_OBJECT = "object"
        arguments?.takeIf { it.containsKey(ARG_OBJECT) }?.apply {
            tv_object.text = getInt(ARG_OBJECT).toString()
        }
    }
}
