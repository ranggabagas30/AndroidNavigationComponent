package com.excercise.androidnavigationcomponent.conditionalnavigation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

import com.excercise.androidnavigationcomponent.R
import kotlinx.android.synthetic.main.fragment_main2.*

/**
 * A simple [Fragment] subclass.
 */
class Main2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = Navigation.findNavController(view)
        btn_view_profile.setOnClickListener { navController.navigate(R.id.action_main2Fragment_to_profileFragment) }
        tv_data_received.text = arguments?.getString("data")
    }
}
