package com.dscvit.thinker.api

import com.dscvit.thinker.model.WikiSearch
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WikiSearchApi {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    // https://en.wikipedia.org/w/api.php?action=query&origin=*&format=json&generator=search&gsrnamespace=0&gsrlimit=10&gsrsearch=india
    @GET("https://en.wikipedia.org/w/api.php")
    suspend fun getSearch(
        @Query("action") action: String = "query",
        @Query("origin") origin: String = "*",
        @Query("format") format: String = "json",
        @Query("generator") generator: String = "search",
        @Query("gsrnamespace") gsrnamespace: Int = 0,
        @Query("gsrlimit") gsrlimit: Int = 20,
        @Query("gsrsearch") gsrsearch: String,
    ): Response<WikiSearch>

}