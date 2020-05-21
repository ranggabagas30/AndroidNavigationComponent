package com.excercise.androidnavigationcomponent.swipeviewpager


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

import com.excercise.androidnavigationcomponent.R

/**
 * A simple [Fragment] subclass.
 */
class Main4Fragment : Fragment() {

    private lateinit var main4CollectionPagerAdapter: Main4CollectionPagerAdapter
    private lateinit var main4ViewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main4, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        main4CollectionPagerAdapter = Main4CollectionPagerAdapter(childFragmentManager)
        main4ViewPager = view.findViewById(R.id.viewPager)
        main4ViewPager.adapter = main4CollectionPagerAdapter
    }
}
