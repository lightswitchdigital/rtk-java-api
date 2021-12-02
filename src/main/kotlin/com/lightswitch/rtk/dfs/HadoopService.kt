package com.lightswitch.rtk.dfs

import com.lightswitch.rtk.dfs.jobs.WordCount

object HadoopService {

    fun runMapReduce() {

        WordCount(System.getProperty("user.dir") + "/input.txt", System.getProperty("user.dir") + "/output.txt")

    }

}