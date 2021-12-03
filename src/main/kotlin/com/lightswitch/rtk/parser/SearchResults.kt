package com.lightswitch.rtk.parser

import com.lightswitch.rtk.UserInfo

class SearchResults : MutableList<SearchResult> by mutableListOf() {

    fun printAllResults() {
        for (result in this) {
            println("${result.title} - ${result.data}")
        }
    }

}

data class SearchResult(
    val type: Type,
    val user: UserInfo,
    val title: String,
    val data: HashMap<String, String>
) {

    enum class Type {
        SOCIAL, OTHER
    }

}