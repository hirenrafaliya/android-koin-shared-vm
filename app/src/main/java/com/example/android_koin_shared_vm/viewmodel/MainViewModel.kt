package com.example.android_koin_shared_vm.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var firstName = mutableStateOf("")

    fun updateName(name: String) = viewModelScope.launch {
        firstName.value = name
    }

}