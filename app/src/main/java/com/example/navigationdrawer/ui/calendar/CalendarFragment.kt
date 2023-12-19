package com.example.navigationdrawer.ui.calendar

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.util.Pair
import androidx.lifecycle.ViewModelProvider
import com.example.navigationdrawer.R
import com.example.navigationdrawer.databinding.FragmentCalendarBinding
import com.google.android.material.datepicker.MaterialDatePicker

class CalendarFragment : Fragment() {

    private var _binding:FragmentCalendarBinding? = null

    private val binding get() = _binding!!


    companion object {
        fun newInstance() = CalendarFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val calendarViewModel = ViewModelProvider(this)[CalendarViewModel::class.java]

        _binding = FragmentCalendarBinding.inflate(inflater,container,false)
        val root: View = binding.root


        val textView: TextView = binding.calenderSpinnerMode
        calendarViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        val rangeCalendar: TextView = binding.rangeCalender
        calendarViewModel.text2.observe(viewLifecycleOwner) {
            rangeCalendar.text = it
        }

        binding.dateField.setEndIconOnClickListener {
            val datePicker =
                MaterialDatePicker.Builder.datePicker()
                    .setTheme(R.style.ThemeOverlay_App_DatePicker)
                    .setTitleText("Select date")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build()

            datePicker.show(parentFragmentManager,"")
        }

        binding.rangeDateField.setEndIconOnClickListener {
            val datePicker =
                MaterialDatePicker.Builder.dateRangePicker()
                    .setTheme(R.style.ThemeOverlay_App_RangeDatePicker)
                    .setTitleText("Select dates")
                    .setSelection(
                        Pair(
                            MaterialDatePicker.thisMonthInUtcMilliseconds(),
                            MaterialDatePicker.todayInUtcMilliseconds()
                        )
                    ).build()

            datePicker.show(parentFragmentManager,"")
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}