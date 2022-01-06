package com.dscvit.thinker.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "I love oranges but hate orange flavoured products :)"
    }
    val text: LiveData<String> = _text
}
