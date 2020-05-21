package com.excercise.androidnavigationcomponent.conditionalnavigation.registration


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.excercise.androidnavigationcomponent.R
import com.excercise.androidnavigationcomponent.conditionalnavigation.login.LoginViewModel
import kotlinx.android.synthetic.main.fragment_choose_user_password.*

/**
 * A simple [Fragment] subclass.
 */
class ChooseUserPasswordFragment : Fragment() {

    private val loginViewModel: LoginViewModel by activityViewModels()
    private val registrationViewModel: RegistrationViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_user_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        // when btn register login is clicked, collect the current values from
        // the two edit texts and pass to the ViewModel to complete registration
        btn_register_login.setOnClickListener {
            registrationViewModel.createAccountAndLogin(
                et_username.text.toString(),
                et_password.text.toString()
            )
        }

        registrationViewModel.registrationState.observe(viewLifecycleOwner, Observer { state ->
            if (state == RegistrationViewModel.RegistrationState.REGISTRATION_COMPLETED) {

                // here we authenticate with the token provided by the ViewModel
                // then pop back to the profile_fragment, where the user authentication
                // status will be tested and should be authenticated
                val authToken = registrationViewModel.authToken
                loginViewModel.authenticate(authToken)
                navController.popBackStack(R.id.profile_fragment, false)
            }
        })

        // if the user presses back, cancel the user registration and pop back
        // to the login fragment. Since this ViewModel is shared at the activity
        // scope, its state must be reset so that it is in the initial state if
        // the user comes back to register later
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            registrationViewModel.userCancelledRegistration()
            navController.popBackStack(R.id.login_fragment,false)
        }
    }
}
