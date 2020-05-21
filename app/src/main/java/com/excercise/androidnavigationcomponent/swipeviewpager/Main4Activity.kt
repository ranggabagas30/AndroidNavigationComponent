package com.excercise.androidnavigationcomponent.swipeviewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.excercise.androidnavigationcomponent.R

class Main4Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.layout_fragment, Main4Fragment())
                .commit()
        }
    }
}
