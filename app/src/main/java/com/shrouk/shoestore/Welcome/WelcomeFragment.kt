package com.shrouk.shoestore.Welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.shrouk.shoestore.R
import com.shrouk.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
  private lateinit var binding:FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_welcome,container,false)
        binding.btnStartTour.setOnClickListener{
            view?.findNavController()?.navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment())
        }
        return binding.root
    }


}