package com.dscvit.thinker.ui.createdeck

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dscvit.thinker.model.Search
import com.dscvit.thinker.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchTopicViewModel @Inject constructor(
    private val repository: AppRepository
) : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "search for a topic"
    }
    val text: LiveData<String> = _text

    private val _searchResponse = MutableLiveData<List<Search>>().apply {
        value = null
    }
    val searchResponse: LiveData<List<Search>> = _searchResponse

    fun getSearchResponse(searchQuery: String) {
        viewModelScope.launch {
            repository.getSearch(searchQuery).let { response ->
                if (response.isSuccessful) {
                    val sortedMap =
                        response.body()?.query?.pages?.toList()?.sortedBy { (_, value) ->
                            value.index
                        }?.toMap()
                    _searchResponse.postValue(sortedMap?.values?.toList())
                } else {
                    // TODO show error message
                }
            }
        }
    }
}
