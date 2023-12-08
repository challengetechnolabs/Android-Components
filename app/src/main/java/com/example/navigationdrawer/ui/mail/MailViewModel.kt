package com.example.navigationdrawer.ui.mail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MailViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is mail Fragment"
    }
    val text: LiveData<String> = _text
}