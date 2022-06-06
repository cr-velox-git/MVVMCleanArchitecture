package com.noobdev.propermvvmarcitecture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.noobdev.propermvvmarcitecture.presentation.ViewModelClass
import dagger.hilt.android.AndroidEntryPoint

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
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                Compose()
            }
        }
    }

    @Preview
    @Composable
    fun Compose() {
        MainCompose(title = "Compose Fragment")
    }

    @Composable
    fun MainCompose(title: String) {

        var (value, updateValue) = remember { mutableStateOf("") }

        //get context
        Column(
            modifier = Modifier
                .padding(0.dp, 50.dp, 0.dp, 0.dp)
                .fillMaxSize()
                .background(color = Color.LightGray),
        ) {
            Text(
                text = title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .align(alignment = Alignment.CenterHorizontally)
                    .background(color = Color.Black),
                color = Color.White,
                fontSize = 22.sp,
                textAlign = TextAlign.Center
            )
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(2.dp),
                value = value,
                onValueChange = { newValue -> updateValue.invoke(newValue) }
            )

            ListItem("#", "Name", "24h", "Price")
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(3) { v: Int ->
                    ListItem(v.toString(), "Name", "24h", "Price")
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
//
//viewModel    //(from view to domin and vise versa and api call)
//
//usecase      //(it takes data from repositries and give it to view model and vise versa)
//repositries
//dataSource   //(local(room db, share preferance)/remote(api calls))
//Api service
