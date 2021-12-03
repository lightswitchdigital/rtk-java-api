package com.lightswitch.rtk.parser

import org.jsoup.Jsoup

object Parser {

    fun test(html: String) {
        return getTextData(html)
    }

    private fun getTextData(html: String) {

        val doc = Jsoup.parse(html)
        println(doc.text())

    }

}