package com.excercise.androidnavigationcomponent.swipeviewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class Main4CollectionPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        val fragment = DemoObjectFragment()
        fragment.arguments = Bundle().apply {
            // sample object is just an integer
            putInt("object", position + 1)
        }
        return fragment
    }

    override fun getCount(): Int {
        return 100
    }
}