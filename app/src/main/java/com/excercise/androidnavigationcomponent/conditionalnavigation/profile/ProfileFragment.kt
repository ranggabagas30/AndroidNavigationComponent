package com.excercise.androidnavigationcomponent.conditionalnavigation.profile


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment.findNavController

import com.excercise.androidnavigationcomponent.R
import com.excercise.androidnavigationcomponent.conditionalnavigation.login.LoginViewModel
import com.excercise.androidnavigationcomponent.conditionalnavigation.registration.RegistrationViewModel

/**
 * A simple [Fragment] subclass.
 */
class ProfileFragment : Fragment() {

    private val loginViewModel: LoginViewModel by activityViewModels()
    private val registrationViewModel: RegistrationViewModel by activityViewModels()

    private lateinit var welcomeTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("profile fragment", "profile fragment")
        welcomeTextView = view.findViewById(R.id.welcome_text_view)
        val navController = Navigation.findNavController(view)

        loginViewModel.authenticationState.observe(viewLifecycleOwner, Observer { authenticationState ->
            when (authenticationState) {
                LoginViewModel.AuthenticationState.AUTHENTICATED -> showWelcomeMessage()
                LoginViewModel.AuthenticationState.UNAUTHENTICATED -> navController.navigate(R.id.login_fragment)
            }
        })
    }

    private fun showWelcomeMessage() {
        welcomeTextView.text = getString(R.string.Welcome, "${loginViewModel.username} with authtoken: ${registrationViewModel.authToken}")
    }
}
