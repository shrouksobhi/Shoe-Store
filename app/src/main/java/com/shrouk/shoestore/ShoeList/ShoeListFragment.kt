package com.shrouk.shoestore.ShoeList

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.shrouk.shoestore.R
import com.shrouk.shoestore.databinding.FragmentShoeListBinding
import com.shrouk.shoestore.databinding.ShoeItemBinding
import com.shrouk.shoestore.model.Shoes

class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding
    private lateinit var shoeViewModel: ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        shoeViewModel=ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        shoeViewModel.shoelist.observe(viewLifecycleOwner)
        { item -> shoeList(item)}
        binding.lifecycleOwner =viewLifecycleOwner
//        shoeViewModel.shoelist.observe(viewLifecycleOwner, {
//
//            for ( item in shoeViewModel.shoelist.value!!) {
//                val shoebinding = ShoeItemBinding.inflate(
//                    LayoutInflater.from(requireContext()),
//                    binding.linearlayout,
//                    false
//                )
//                shoebinding.name.text = item.name
//                shoebinding.description.text = item.description
//                shoebinding.company.text = item.company
//                shoebinding.size.text = item.shoeSize
//
//                binding.linearlayout.addView(shoebinding.root)
//            }

//
//        }
//        )
//
        binding.btnAdd.setOnClickListener {
            view?.findNavController()
                ?.navigate(ShoeListFragmentDirections.actionShoeListFragmentToDetailsFragment())
        }
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.nav_drawer, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                return when (menuItem.itemId) {
                    R.id.logInFragment -> {
                        view?.findNavController()
                            ?.navigate(ShoeListFragmentDirections.actionShoeListFragmentToLogInFragment())
                        true
                    }

                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return binding.root
    }
    private fun shoeList(item: List<Shoes>){

        item.forEach{

            val bindingView =ShoeItemBinding.inflate(LayoutInflater.from(requireContext()), binding.linearlayout, false)

            with(bindingView){
             shoeCompany.text=it.company
                shoeName.text=it.name
                shoeSize.text=it.shoeSize
                shoeDescription.text=it.description
            }
            binding.linearlayout.addView(bindingView.root)

        }
    }
}





