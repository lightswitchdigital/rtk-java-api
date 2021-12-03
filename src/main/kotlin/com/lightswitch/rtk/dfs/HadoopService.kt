package com.lightswitch.rtk.dfs

import com.lightswitch.rtk.UserInfo
import com.lightswitch.rtk.dfs.jobs.parse.ParseJob
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path
import org.apache.hadoop.io.IOUtils
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.InputStream
import java.net.URI

object HadoopService {

    private val Log: Logger = LoggerFactory.getLogger(HadoopService::class.java)

    fun test() {
        val uri: String = "source.txt"
        val conf = Configuration()
        val fs: FileSystem = FileSystem.get(URI.create("/"), conf)
        var input: InputStream? = null
        try {
            input = fs.open(Path(uri))
            IOUtils.copyBytes(input, System.out, 4096, false)
        } finally {
            IOUtils.closeStream(input)
        }
    }

    fun runMapReduce() {

        val job = ParseJob(
            ParseJob.DocType.HTML,
            UserInfo("123", "Егор Овчинников"),
            System.getProperty("user.dir") + "/input.html",
            System.getProperty("user.dir") + "/output.txt"
        )

        job.run()

    }

}