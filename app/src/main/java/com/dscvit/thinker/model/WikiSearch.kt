package com.dscvit.thinker.model

data class WikiSearch(
    val batchcomplete: String,
    val `continue`: Continue,
    val query: Query
)