package com.excercise.androidnavigationcomponent.conditionalnavigation.registration


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController

import com.excercise.androidnavigationcomponent.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_enter_user_profile_info.*

/**
 * A simple [Fragment] subclass.
 */
class EnterUserProfileInfoFragment : Fragment() {

    val registrationViewModel by activityViewModels<RegistrationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_enter_user_profile_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()

        // when btn next is clicked, then collect full name and bio data from text field
        // and pass these to the ViewModel to store
        btn_next.setOnClickListener {
            val name = et_fullname.text.toString()
            val bio = et_bio.text.toString()
            registrationViewModel.collecProfileData(name, bio)
        }

        // RegistrationViewModel will update the registrationState to
        // COLLECT_USER_PASSWORD when ready to move to the choose username and
        // password screen.
        registrationViewModel.registrationState.observe(viewLifecycleOwner, Observer {state ->
            if (state == RegistrationViewModel.RegistrationState.COLLECT_USER_PASSWORD) {
                navController.navigate(R.id.move_to_choose_user_password)
            } else if (state == RegistrationViewModel.RegistrationState.REGISTRATION_INVALID) {
                showError(view)
            }
        })

        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner) {
            Log.d(EnterUserProfileInfoFragment::class.java.simpleName, "back")
            registrationViewModel.userCancelledRegistration()
            navController.popBackStack(R.id.login_fragment, false)
        }
    }

    private fun showError(view: View) {
        Snackbar.make(view, "Invalid data", Snackbar.LENGTH_LONG).show()
    }
}
