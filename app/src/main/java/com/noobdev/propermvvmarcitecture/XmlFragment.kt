package com.noobdev.propermvvmarcitecture

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.noobdev.propermvvmarcitecture.databinding.FragmentXmlBinding
import com.noobdev.propermvvmarcitecture.presentation.ViewModelClass
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