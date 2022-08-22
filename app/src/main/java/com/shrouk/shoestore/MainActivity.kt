package com.shrouk.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.shrouk.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

private lateinit var drawerLayout: DrawerLayout
private lateinit var appBarConfiguration : AppBarConfiguration
    lateinit var controller: NavController

override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    drawerLayout = binding.drawerLayout
    val navHostFragment =
        supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
    val inflater = navHostFragment.navController.navInflater
    controller = navHostFragment.navController
    controller.navigate(R.id.logInFragment)

    NavigationUI.setupActionBarWithNavController(this,controller)
}
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}




