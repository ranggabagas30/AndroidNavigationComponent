package com.excercise.androidnavigationcomponent.conditionalnavigation.login


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.navigateUp

import com.excercise.androidnavigationcomponent.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    private val loginViewModel: LoginViewModel by activityViewModels()
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("login fragment", "login fragment")

        navController = Navigation.findNavController(view)
        btn_login.setOnClickListener {
            loginViewModel.authenticate(et_username.text.toString(), et_password.text.toString())
        }

        btn_register.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_registerFragment)
        }

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            loginViewModel.refuseAuthentication()
            navController.popBackStack(R.id.main2_fragment, false)
        }

        loginViewModel.authenticationState.observe(viewLifecycleOwner, Observer {authenticationState ->
            when (authenticationState) {
                LoginViewModel.AuthenticationState.AUTHENTICATED -> navController.popBackStack()
                LoginViewModel.AuthenticationState.INVALID_AUTHENTICATION -> showErrorMessage(view)
            }
        })
    }

    private fun showErrorMessage(view: View) {
        Snackbar.make(view, "Invalid Authentication", Snackbar.LENGTH_SHORT).show()
    }
}
