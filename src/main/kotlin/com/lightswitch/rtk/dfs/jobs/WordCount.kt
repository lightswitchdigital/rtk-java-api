package com.lightswitch.rtk.dfs.jobs

import org.apache.hadoop.fs.Path
import org.apache.hadoop.io.IntWritable
import org.apache.hadoop.io.Text
import org.apache.hadoop.mapreduce.Job
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat

class WordCount @Throws(Exception::class) constructor(inputPath: String, outputPath: String) {

    init {
        val job = Job.getInstance()
        FileInputFormat.addInputPath(job, Path(inputPath))
        FileOutputFormat.setOutputPath(job, Path(outputPath))
        job.setJarByClass(WordCount::class.java)
        job.reducerClass = WordCountReducer::class.java
        job.mapperClass = WordCountMapper::class.java
        job.outputKeyClass = Text::class.java
        job.outputValueClass = IntWritable::class.java
        job.waitForCompletion(true)
    }

}
