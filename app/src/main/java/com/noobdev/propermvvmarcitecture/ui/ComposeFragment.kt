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


    val viewModel: ViewModelClass by activityViewModels()

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

//domain       // buisness model
//entity       // data transfer object model
//viewdata     // view data model(show on screen)

//viewModel    //(from view to domin and vise versa and api call)

//usecase      //(it takes data from repositries and give it to view model and vise versa)
//repositries
//dataSource   //(local(room db, share preferance)/remote(api calls))
//Api service
