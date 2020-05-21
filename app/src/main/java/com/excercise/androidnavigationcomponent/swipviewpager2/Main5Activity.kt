package com.excercise.androidnavigationcomponent.swipviewpager2

import android.graphics.Point
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import com.excercise.androidnavigationcomponent.R
import kotlinx.android.synthetic.main.fragment_main5.*

class Main5Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)

        val displayMetrics = DisplayMetrics()
        display.getMetrics(displayMetrics)

        Log.d("window", "height: ${size.y}")
        Log.d("window", "width: ${size.x}")

        Log.d("displayMetrics", "height px: ${displayMetrics.heightPixels}")
        Log.d("displayMetrics", "width px: ${displayMetrics.widthPixels}")
        Log.d("displayMetrics", "$displayMetrics")

        val realDisplayMetrics = DisplayMetrics()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            display.getRealMetrics(realDisplayMetrics)
            Log.d("realDisplayMetrics", "$realDisplayMetrics")
        }

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.main5_fragment_layout, Main5Fragment())
                .commit()
        }
    }
}
