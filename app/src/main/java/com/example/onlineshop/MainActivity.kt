package com.example.onlineshop

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.*
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.onlineshop.databinding.ActivityMainBinding

open class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::bind, R.id.container)
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(
            R.id.nav_host_fragment
        ) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment,
                R.id.productDetailsFragment,
                R.id.profileFragment -> {
                    showSystemUI(binding.root)
                    binding.bottomNav.isVisible = true
                }
                else -> {
                    binding.bottomNav.isGone = true
                }
            }
        }
    }

    private fun showSystemUI(container: View) {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        WindowInsetsControllerCompat(window, container).show(WindowInsetsCompat.Type.systemBars())
    }

}