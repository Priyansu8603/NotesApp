package com.example.notesapp.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.notesapp.Data.Model.UserRequest
import com.example.notesapp.Data.Model.UserResponse
import com.example.notesapp.R
import com.example.notesapp.ViewModel.AuthViewModel
import com.example.notesapp.databinding.FragmentLoginBinding
import com.example.notesapp.ui.activity.NotesActivity
import com.example.notesapp.utilities.NetworkResult
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val authViewModel by viewModels<AuthViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtRegister.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.loginBtn.setOnClickListener {
            val validateResult = validateUserInput()
            if (validateResult.first) {
                authViewModel.loginUser(getUserRequest())
            }
            else {
                binding.errorTxt.text = validateResult.second
            }
        }

        bindObserver()

    }

    private fun getUserRequest(): UserRequest {
        val emailAddress = binding.signInEmailEditText.text.toString()
        val password = binding.signInPasswordEditText.text.toString()

        return UserRequest(emailAddress,password,"")
    }

    private fun validateUserInput(): Pair<Boolean, String> {

        val userRequest = getUserRequest()
        return authViewModel.validateCredentials(userRequest.email,"",userRequest.password,"",true)

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