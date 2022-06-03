package com.noobdev.propermvvmarcitecture

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updateLayoutParams
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import com.noobdev.propermvvmarcitecture.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
        private set

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        WindowCompat.setDecorFitsSystemWindows(window, false)



        ViewCompat.setOnApplyWindowInsetsListener(binding.rootLayout) { rootLayout: View, windowInsets: WindowInsetsCompat ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            rootLayout.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                leftMargin = insets.left
                topMargin = 0
                rightMargin = insets.right
                bottomMargin = insets.bottom
            }
            WindowInsetsCompat.CONSUMED
        }
        navController = Navigation.findNavController(this,R.id.nav_host_fragment)

            binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            menuItem.onNavDestinationSelected(navController)
        }
        binding.bottomNavigation.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.xmlFragment -> {
                    navController.navigate(R.id.action_mainFragment_to_xmlFragment)
                    true
                }
                R.id.composeFragment -> {
                    navController.navigate(R.id.action_mainFragment_to_composeFragment)
                    true
                }
                else -> {
                    navController.navigateUp()
                }
            }
        }

    }

    override fun onResume() {
        super.onResume()

        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.apply {
                when (destination.id) {
                    R.id.xmlFragment, R.id.composeFragment -> {
                        binding.bottomNavigation.visibility = View.GONE
                    }
                    else -> {
                        binding.bottomNavigation.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}