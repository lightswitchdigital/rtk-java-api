package com.lightswitch.rtk

import com.lightswitch.rtk.parser.Parser
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RtkApplication : CommandLineRunner {

    companion object {
        var Log: Logger = LoggerFactory.getLogger(RtkApplication::class.java)
    }

    override fun run(vararg args: String?) {
        Parser.test()
    }

}

fun main(args: Array<String>) {
    RtkApplication.Log.info("starting test application")
    runApplication<RtkApplication>(*args)
}
