package com.lightswitch.rtk.dfs.jobs.parse

import org.apache.hadoop.io.Text
import java.io.IOException

class ParseReducer : org.apache.hadoop.mapreduce.Reducer<Text, Text, Text, Text>() {

    @Throws(IOException::class)
    override fun reduce(key: Text?, values: MutableIterable<Text>?, context: Context?) {

//            output!!.collect(key, IntWritable(sum))
        context!!.write(key, Text("sdfsdf"))

    }

}