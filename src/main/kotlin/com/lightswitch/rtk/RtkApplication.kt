package com.lightswitch.rtk

import com.lightswitch.rtk.dfs.jobs.parse.ParseJob
import com.lightswitch.rtk.solr.SolrService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.support.AbstractApplicationContext
import org.springframework.context.support.ClassPathXmlApplicationContext


@SpringBootApplication(scanBasePackages = ["com.lightswitch.rtk"])
class RtkApplication : CommandLineRunner {

    companion object {
        var Log: Logger = LoggerFactory.getLogger(RtkApplication::class.java)
    }

    override fun run(vararg args: String?) {

        val context: AbstractApplicationContext = ClassPathXmlApplicationContext(
            "/META-INF/spring/application-context.xml", ParseJob::class.java
        )

        val models = SolrService.Search.search()

    }

}

fun main(args: Array<String>) {
    RtkApplication.Log.info("starting test application")
    runApplication<RtkApplication>(*args)
}
