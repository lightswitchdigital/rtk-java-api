package com.lightswitch.rtk.dfs.jobs

import org.apache.hadoop.io.IntWritable
import org.apache.hadoop.io.Text
import java.io.IOException

class WordCountReducer : org.apache.hadoop.mapreduce.Reducer<Text, IntWritable, Text, IntWritable>() {

    @Throws(IOException::class)
    override fun reduce(key: Text?, values: MutableIterable<IntWritable>?, context: Context?) {

        var sum = 0
        values!!.forEach {
            sum += it.get()
        }
//            output!!.collect(key, IntWritable(sum))
        context!!.write(key, IntWritable(sum))

    }


}