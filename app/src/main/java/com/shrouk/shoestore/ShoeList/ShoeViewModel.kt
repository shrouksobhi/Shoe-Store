package com.shrouk.shoestore.ShoeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shrouk.shoestore.model.Shoes

class ShoeViewModel : ViewModel() {
    private var shoesList = mutableListOf<Shoes>()

    private var _shoeList=MutableLiveData<MutableList<Shoes>>()
    val shoelist:LiveData<MutableList<Shoes>>
    get()=_shoeList

    fun addShoe(name:String,size:String,company:String,description:String){
      val shoe= Shoes(name,company,size,description)
        shoesList.add(shoe)
        _shoeList.value = shoesList
    }

}