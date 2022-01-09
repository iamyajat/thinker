package com.dscvit.thinker.ui.createdeck

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchTopicViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Create Deck Fragment"
    }
    val text: LiveData<String> = _text
}