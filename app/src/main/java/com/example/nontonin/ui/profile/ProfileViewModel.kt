package com.example.nontonin.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _profileText = MutableLiveData<String>().apply {
        value = ""
    }
    val profileText: LiveData<String> = _profileText
}