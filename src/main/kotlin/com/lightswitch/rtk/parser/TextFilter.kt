package com.lightswitch.rtk.parser

import org.jsoup.select.Elements

object TextFilter {

    fun filter(els: Elements): Elements {
        var result = Elements()

        for (el in els) {
            if (el.text().length >= 20) {
                result.add(el)
            }
        }

        return result
    }

}