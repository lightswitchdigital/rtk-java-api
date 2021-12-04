package com.lightswitch.rtk.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {

    @GetMapping("/gateway/get-records")
    fun getRecords(@RequestParam params: Map<String, String>): String {
        for (entry in params.entries) {
            println(entry.key + "/" + entry.value)
        }

        return "awesome!"
    }

}