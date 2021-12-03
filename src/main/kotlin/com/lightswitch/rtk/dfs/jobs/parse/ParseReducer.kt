package com.lightswitch.rtk.dfs.jobs.parse

import org.apache.hadoop.io.ArrayWritable
import org.apache.hadoop.io.Text
import java.io.IOException

class ParseReducer : org.apache.hadoop.mapreduce.Reducer<Text, HashMap<String, String>, Text, ArrayWritable>() {

    @Throws(IOException::class)
    override fun reduce(key: Text?, values: Iterable<HashMap<String, String>>?, context: Context?) {


    }

}