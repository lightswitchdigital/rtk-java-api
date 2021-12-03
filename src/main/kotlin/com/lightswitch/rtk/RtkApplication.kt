package com.lightswitch.rtk

import com.lightswitch.rtk.dfs.jobs.parse.ParseJob
import com.lightswitch.rtk.parser.Parser
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.AbstractApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext


@SpringBootApplication
class RtkApplication : CommandLineRunner {

    companion object {
        var Log: Logger = LoggerFactory.getLogger(RtkApplication::class.java)
    }

    override fun run(vararg args: String?) {

        val context: AbstractApplicationContext = ClassPathXmlApplicationContext(
            "/META-INF/spring/application-context.xml", ParseJob::class.java
        )
//        SolrService.test()
//        SolrService.Search.search()

        println(Parser.parseFromFile("index.html"))
//        Parser.parseAllFiles("/")
//        HadoopService.runMapReduce()
//        HadoopService.test()

    }

}

fun main(args: Array<String>) {
    RtkApplication.Log.info("starting test application")
    runApplication<RtkApplication>(*args)
}
