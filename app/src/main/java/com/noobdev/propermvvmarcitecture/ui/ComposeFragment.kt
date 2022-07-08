package com.noobdev.propermvvmarcitecture.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.noobdev.propermvvmarcitecture.R
import com.noobdev.propermvvmarcitecture.presentation.ViewModelClass
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@OptIn(ExperimentalCoroutinesApi::class)
@AndroidEntryPoint
class ComposeFragment : Fragment() {


    private val viewModel: ViewModelClass by activityViewModels()

    private val navController: NavController by lazy {
        Navigation.findNavController(
            requireActivity(),
            R.id.nav_host_fragment
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            // Dispose of the Composition when the view's LifecycleOwner
            // is destroyed
            val data = viewModel.response.value

            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                data?.data?.let {
                    MainComposeFragment(
                        title = "Compose Fragment",
                        dataItemList = it
                    )
                }
            }
        }
    }


    //------------------------------------------------//
    private fun onBackPress() {
        navController.navigate(R.id.action_composeFragment_to_mainFragment)
    }
}


