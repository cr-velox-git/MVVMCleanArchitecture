package com.noobdev.propermvvmarcitecture.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.noobdev.propermvvmarcitecture.R
import com.noobdev.propermvvmarcitecture.databinding.FragmentXmlBinding
import com.noobdev.propermvvmarcitecture.presentation.ui.ViewModelClass
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class XmlFragment : Fragment(R.layout.fragment_xml) {

    val viewModel: ViewModelClass by activityViewModels()

    private var binding: FragmentXmlBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentXmlBinding.bind(view)


    }
}