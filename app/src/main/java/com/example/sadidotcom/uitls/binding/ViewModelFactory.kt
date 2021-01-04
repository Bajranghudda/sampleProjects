package com.example.lab49competency.utils

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sadidotcom.data.model.repository.PersonRepository
import com.example.sadidotcom.ui.main.viewmodel.MainViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory() : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            //return MainViewModel(PersonRepository()) as T

        }
        throw IllegalArgumentException("Unknown class name")
    }
}