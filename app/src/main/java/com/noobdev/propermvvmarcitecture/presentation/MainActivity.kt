package com.noobdev.propermvvmarcitecture.presentation

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
import androidx.navigation.ui.onNavDestinationSelected
import com.noobdev.propermvvmarcitecture.R
import com.noobdev.propermvvmarcitecture.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    //it should not be private
    @Inject //Field injection
    lateinit var baseApplication: BassApplication

    lateinit var base2: BassApplication

    private lateinit var binding: ActivityMainBinding
        private set

    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        WindowCompat.setDecorFitsSystemWindows(window, false)



//        baseApplication.sendRandom
//
//        APi{
//
//            randomClass.randomString
//            randomClass.randomString="II"
//        }
//        APi2{
//            randomClass.randomString
//
//        }



        //base2.sendRandom//this will throw an error, cause never created

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
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

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