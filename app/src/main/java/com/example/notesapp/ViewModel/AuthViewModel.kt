package com.example.notesapp.ViewModel

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.Data.Model.UserRequest
import com.example.notesapp.Data.Model.UserResponse
import com.example.notesapp.Data.Repository.UserRepository
import com.example.notesapp.utilities.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel() {

    val userResponseLiveData : LiveData<NetworkResult<UserResponse>> get() = userRepository.userResponseLiveData

    fun registerUser(userRequest: UserRequest){
        viewModelScope.launch {
            userRepository.registerUser(userRequest)
        }
    }

    fun loginUser(userRequest: UserRequest){
        viewModelScope.launch {
            userRepository.loginUser(userRequest)
        }
    }

    fun validateCredentials( email: String, username: String, password: String, confirmPassword: String, isLogin:Boolean): Pair<Boolean,String>{
        var result = Pair(true,"")
        if((email.isEmpty() || (!isLogin && username.isEmpty()) || password.isEmpty() || (!isLogin && confirmPassword.isEmpty()))){
            result = Pair(false,"Please Provide the Credentials")
        }
        else if( !isLogin && password != confirmPassword){
            result = Pair(false,"Password and Confirm Password does not match")
        }
        else if(password.length < 6){
            result = Pair(false,"Password should be greater than 6 characters")
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            result = Pair(false,"Email is Invalid")
        }
        return result
    }

}