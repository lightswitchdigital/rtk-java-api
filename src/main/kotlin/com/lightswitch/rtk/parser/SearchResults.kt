package com.lightswitch.rtk.parser

class SearchResults : MutableList<SearchResult> by mutableListOf() {

    fun printAllResults() {
        for (result in this) {
            println("${result.title} - ${result.data}")
        }
    }

}

data class SearchResult(val title: String, val data: HashMap<String, String>) {


}