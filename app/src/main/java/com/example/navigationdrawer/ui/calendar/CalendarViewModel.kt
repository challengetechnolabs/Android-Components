package com.example.navigationdrawer.ui.calendar

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.datepicker.MaterialDatePicker
import kotlinx.coroutines.flow.DEFAULT_CONCURRENCY

class CalendarViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Calendar Spinner mode"
    }
    val text: LiveData<String> = _text

    private val _text2 = MutableLiveData<String>().apply {
        value = "This is Range Calendar"
    }
    val text2: LiveData<String> = _text2
}