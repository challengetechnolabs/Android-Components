package com.example.navigationdrawer.ui.spinner

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SpinnerViewModel : ViewModel() {

    private val items = MutableLiveData<List<OperatedCountry>>()

    init {
        items.value = listOf(OperatedCountry.UNITED_KINGDOM,OperatedCountry.NEW_ZEALAND,OperatedCountry.USA,OperatedCountry.CANADA)
    }

    fun getItems(): LiveData<List<OperatedCountry>> {
        return items
    }

    fun onItemSelected(item: String) {
        // Do something with the selected item.
    }
}