package com.example.notesapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.notesapp.Data.Model.UserRequest
import com.example.notesapp.Data.Model.UserResponse
import com.example.notesapp.R
import com.example.notesapp.ViewModel.AuthViewModel
import com.example.notesapp.databinding.FragmentRegisterBinding
import com.example.notesapp.ui.activity.NotesActivity
import com.example.notesapp.utilities.NetworkResult
import com.example.notesapp.utilities.TokenManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class RegisterFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val authViewModel by viewModels<AuthViewModel>()

    @Inject
    lateinit var tokenManager: TokenManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginText.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }


        binding.RegisterButton.setOnClickListener {
            val validateResult = validateUserInput()
            if (validateResult.first) {
                authViewModel.registerUser(getUserRequest())
            }
            else{
                binding.errorTxt.text = validateResult.second
            }
        }

        bindObserver()


    }

    private fun getUserRequest():UserRequest{
        val emailAddress = binding.emailEditText.text.toString()
        val username = binding.usernameEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        val confirmPassword = binding.confirmPasswordEditText.text.toString()

        return UserRequest(emailAddress,confirmPassword,username)
    }

    private fun validateUserInput(): Pair<Boolean, String> {
        val emailAddress = binding.emailEditText.text.toString()
        val username = binding.usernameEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        val confirmPassword = binding.confirmPasswordEditText.text.toString()

        return authViewModel.validateCredentials(emailAddress,username,password,confirmPassword,false)

        // iff i have no confirm password then do it like this
        // val userRequest = getUserRequest()
        // return authViewModel.validateCredentials(userRequest.email,userRequest.username,userRequest.password)


    }



    private fun bindObserver() {
        authViewModel.userResponseLiveData.observe(
            viewLifecycleOwner, Observer { it: NetworkResult<UserResponse> ->

                binding.progressBar.isVisible= false

                when (it) {
                    is NetworkResult.Success -> {

                        //token implementation
                        tokenManager.saveToken(it.data!!.token)

                        val intent = Intent(requireActivity(), NotesActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)
                        requireActivity().finish()


                    }

                    is NetworkResult.Error -> {
                        binding.errorTxt.text = it.message
                    }

                    is NetworkResult.Loading -> {
                        binding.progressBar.isVisible = true
                    }
                }

            })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}