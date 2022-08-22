package com.shrouk.shoestore.Login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.shrouk.shoestore.R
import com.shrouk.shoestore.databinding.FragmentLogInBinding

class LogInFragment : Fragment() {
    private lateinit var binding:FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_log_in,container,false)
        binding.signinbutton.setOnClickListener {

            val email = binding.email.text.toString().trim()
            val password = binding.password.text.toString().trim()
            //check validation on email and pssword...
            if (email.isEmpty()) {
                binding.email.error = "Email required"
                binding.email.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.password.error = "Password required"
                binding.password.requestFocus()
                return@setOnClickListener
            }

            view?.findNavController()
                ?.navigate(LogInFragmentDirections.actionLogInFragmentToWelcomeFragment())


        }
        binding.signupbt.setOnClickListener{
            view?.findNavController()
                ?.navigate(LogInFragmentDirections.actionLogInFragmentToWelcomeFragment())
        }
        return binding.root
    }

}