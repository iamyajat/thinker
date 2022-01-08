package com.dscvit.thinker.ui.profile

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class ProfileViewModel : ViewModel() {

    private val firebaseUser: FirebaseUser = Firebase.auth.currentUser!!

    private val _username = MutableLiveData<String>().apply {
        val u = "iamyajat"
        value = "@$u"
    }
    val username: LiveData<String> = _username

    private val _bio = MutableLiveData<String>().apply {
        value = firebaseUser.email
    }
    val bio: LiveData<String> = _bio

    private val _name = MutableLiveData<String>().apply {
        value = firebaseUser.displayName
    }
    val name: LiveData<String> = _name

    private val _imageUrl = MutableLiveData<Uri>().apply {
        value = firebaseUser.photoUrl
    }
    val imageUrl: LiveData<Uri> = _imageUrl
}
