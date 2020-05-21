package com.excercise.androidnavigationcomponent.conditionalnavigation.registration

import android.text.TextUtils
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistrationViewModel: ViewModel() {

    enum class RegistrationState {
        COLLECT_PROFILE_DATA,
        COLLECT_USER_PASSWORD,
        REGISTRATION_INVALID,
        REGISTRATION_COMPLETED
    }

    val registrationState = MutableLiveData<RegistrationState>()
    var name = MutableLiveData<String>()
    var bio = MutableLiveData<String>()
    var username = MutableLiveData<String>()
    var password = MutableLiveData<String>()

    // gonna be set at the end of the registration process
    var authToken = ""
        private set

    init {
        name.value = null
        bio.value = null
        registrationState.value = RegistrationState.COLLECT_PROFILE_DATA
    }

    fun collecProfileData(name: String, bio: String) {
        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(bio)) {
            this.name.value = name
            this.bio.value = bio
            registrationState.value = RegistrationState.COLLECT_USER_PASSWORD
        } else {
            registrationState.value = RegistrationState.REGISTRATION_INVALID
        }
    }

    fun createAccountAndLogin(username: String, password: String) {
        // create account
        // authenticate
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password) &&
                username == password) {
            this.username.value = username
            this.password.value = password
            this.authToken = "valid_token"
            registrationState.value = RegistrationState.REGISTRATION_COMPLETED
        } else {
            registrationState.value = RegistrationState.REGISTRATION_INVALID
        }
    }

    fun userCancelledRegistration() : Boolean {
        // clear existing registration data
        this.name.value = null
        this.bio.value = null
        registrationState.value = RegistrationState.COLLECT_PROFILE_DATA
        authToken = ""
        return true
    }
}