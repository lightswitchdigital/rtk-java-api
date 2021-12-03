package com.lightswitch.rtk.dfs.jobs.parse

import com.lightswitch.rtk.UserInfo
import com.lightswitch.rtk.dfs.HadoopService
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.Path
import org.apache.hadoop.io.Text
import org.apache.hadoop.mapreduce.Job
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class ParseJob constructor(
    private val type: DocType,
    private val user: UserInfo,
    private val inputPath: String,
    private val outputPath: String
) {

    enum class DocType {
        HTML, TXT, XML
    }

    private val Log: Logger = LoggerFactory.getLogger(HadoopService::class.java)

    @Throws(Exception::class)
    fun run() {

        Log.info("Starting a parse job of $type")

        val conf = Configuration()
        val job = Job.getInstance(conf, "DocParse")

        FileInputFormat.addInputPath(job, Path(inputPath))
        FileOutputFormat.setOutputPath(job, Path(outputPath))
        job.setJarByClass(ParseJob::class.java)
        job.reducerClass = ParseReducer::class.java
        job.mapperClass = ParseMapper::class.java
        job.outputKeyClass = Text::class.java
        job.outputValueClass = Text::class.java

        job.waitForCompletion(true)

        Log.info("Parse job finished")

    }

}