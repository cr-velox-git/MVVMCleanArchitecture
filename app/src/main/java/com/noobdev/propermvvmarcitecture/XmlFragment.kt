package com.noobdev.propermvvmarcitecture

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.noobdev.propermvvmarcitecture.databinding.FragmentXmlBinding

class XmlFragment : Fragment(R.layout.fragment_xml) {
    private var binding: FragmentXmlBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentXmlBinding.bind(view)


    }
}