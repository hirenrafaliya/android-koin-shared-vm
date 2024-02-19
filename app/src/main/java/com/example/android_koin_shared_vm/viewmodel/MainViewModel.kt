package com.example.android_koin_shared_vm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var firstName = ""

    fun updateName(name: String) = viewModelScope.launch {
        firstName = name
    }

}