package com.noobdev.propermvvmarcitecture.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.noobdev.propermvvmarcitecture.R
import com.noobdev.propermvvmarcitecture.databinding.FragmentXmlBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class XmlFragment : Fragment(R.layout.fragment_xml) {

    private val TAG = "XmlFragment"
    private val viewModel: ViewModelClass by activityViewModels()

    private var binding: FragmentXmlBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentXmlBinding.bind(view)

        val response = viewModel.response.value
        Log.d(TAG, response?.data.toString())
    }
}