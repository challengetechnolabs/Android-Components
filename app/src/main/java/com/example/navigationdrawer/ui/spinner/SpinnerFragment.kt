package com.example.navigationdrawer.ui.spinner

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import androidx.lifecycle.ViewModelProvider
import com.example.navigationdrawer.R
import com.example.navigationdrawer.databinding.FragmentSpinnerBinding

class SpinnerFragment : Fragment() {

    private var _binding: FragmentSpinnerBinding? = null
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = SpinnerFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val spinnerViewModel = ViewModelProvider(this)[SpinnerViewModel::class.java]

        _binding = FragmentSpinnerBinding.inflate(inflater,container,false)
        val root: View = binding.root

        binding.sCountry.adapter = CountryAdapter(requireContext(),spinnerViewModel.getItems().value!!)
        binding.sCountry.setSelection(1)

        return root
    }
}