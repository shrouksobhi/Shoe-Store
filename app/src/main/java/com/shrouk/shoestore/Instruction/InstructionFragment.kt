package com.shrouk.shoestore.Instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.shrouk.shoestore.R
import com.shrouk.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {
private lateinit var binding:FragmentInstructionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_instruction,container,false)
        binding.next.setOnClickListener{
            view?.findNavController()?.navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeListFragment())
        }

        return binding.root

    }


}