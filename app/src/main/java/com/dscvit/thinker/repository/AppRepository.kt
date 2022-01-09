package com.dscvit.thinker.repository

import com.dscvit.thinker.api.WikiSearchApi
import javax.inject.Inject

class AppRepository
@Inject
constructor(private val wikiSearchApi: WikiSearchApi) {
    suspend fun getSearch(search: String) = wikiSearchApi.getSearch(gsrsearch = search)
}