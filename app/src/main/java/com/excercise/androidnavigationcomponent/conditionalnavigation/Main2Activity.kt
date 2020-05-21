package com.excercise.androidnavigationcomponent.conditionalnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.excercise.androidnavigationcomponent.R
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val navController = findNavController(R.id.nav2_host_fragment)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        main2_toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav2_host_fragment)
        return when(navController.currentDestination?.id) {
            R.id.login_fragment -> {
                Log.d("navigate up", "login fragment navigate up")
                navController.popBackStack(R.id.main2_fragment, false)
            } else -> navController.navigateUp()
        }
    }
}
