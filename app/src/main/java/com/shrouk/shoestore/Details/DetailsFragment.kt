package com.shrouk.shoestore.Details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.shrouk.shoestore.R
import com.shrouk.shoestore.ShoeList.ShoeViewModel
import com.shrouk.shoestore.databinding.FragmentDetailsBinding
import com.shrouk.shoestore.model.Shoes

class DetailsFragment : Fragment() {
   private lateinit var binding:FragmentDetailsBinding
   private lateinit var shoeViewModel : ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_details,container,false)
        shoeViewModel= ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        binding.shoeItem= Shoes()
        binding.btnsave.setOnClickListener{
            sendShoeData()

//            val showBinding = binding.shoeItem
//            val name = showBinding?.name.toString()
//            val company = showBinding?.company.toString()
//            val description = showBinding?.description.toString()
//            val shoeSize = showBinding?.shoeSize.toString()
//
//                shoeViewModel.addShoe(name,company,  shoeSize, description)
//

           // view?.findNavController()?.navigate(DetailsFragmentDirections.actionDetailsFragmentToShoeListFragment())
        }

        binding.btncancel.setOnClickListener{
            view?.findNavController()?.navigate(DetailsFragmentDirections.actionDetailsFragmentToShoeListFragment())
        }
        return binding.root
    }

    private fun sendShoeData() {
        val shoeData = binding.shoeItem
        val shoeName =  shoeData?.name.toString()
        val shoeCompany =  shoeData?.company.toString()
        val shoeDescription = shoeData?.description.toString()
        val shoeSize =  shoeData?.shoeSize.toString()
           shoeViewModel.addShoe(shoeName, shoeSize, shoeCompany, shoeDescription)
            findNavController().navigate(DetailsFragmentDirections.actionDetailsFragmentToShoeListFragment())
        }
    }
