package com.example.navigationdrawer.ui.mail

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.navigationdrawer.R
import com.example.navigationdrawer.databinding.FragmentMailBinding

class MailFragment : Fragment() {

    private var _binding : FragmentMailBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    companion object {
        fun newInstance() = MailFragment()
    }

//    private val viewModel: MailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         val mailViewModel = ViewModelProvider(this)[MailViewModel::class.java]

        _binding = FragmentMailBinding.inflate(inflater,container,false)
        val root: View = binding.root

        val textView: TextView = binding.textMail
        mailViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}