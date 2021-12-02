package com.lightswitch.rtk.dfs.jobs

import org.apache.commons.text.StringTokenizer
import org.apache.hadoop.io.IntWritable
import org.apache.hadoop.io.LongWritable
import org.apache.hadoop.io.Text
import java.io.IOException

class WordCountMapper : org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, Text, IntWritable>() {

    private val one = IntWritable(1)
    private val word = Text()

    @Throws(IOException::class)
    @Override
    override fun map(key: LongWritable?, value: Text?, context: Context?) {

        val line = value.toString()
        val tokenizer = StringTokenizer(line)

        while (tokenizer.hasNext()) {
            word.set(tokenizer.nextToken())
            context?.write(Text(word), IntWritable(1))
        }

    }

}