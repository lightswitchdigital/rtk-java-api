package com.lightswitch.rtk.dfs.jobs.parse

import org.apache.hadoop.io.IntWritable
import org.apache.hadoop.io.LongWritable
import org.apache.hadoop.io.Text
import java.io.IOException

class ParseMapper : org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, Text, IntWritable>() {

    @Throws(IOException::class)
    @Override
    override fun map(key: LongWritable?, value: Text?, context: Context?) {

//        val line = value.toString()
//        val tokenizer = StringTokenizer(line)
//
//        while (tokenizer.hasNext()) {
//            word.set(tokenizer.nextToken())
//            context?.write(Text(word), IntWritable(1))
//        }

    }

}