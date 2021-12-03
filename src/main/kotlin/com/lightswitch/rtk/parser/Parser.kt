package com.lightswitch.rtk.parser

import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileStatus
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path
import org.jsoup.Jsoup
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.File
import java.net.URI

object Parser {

    var Log: Logger = LoggerFactory.getLogger(Parser::class.java)

    private const val USER_AGENT =
        "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36"

    private const val TIMEOUT = 4

    fun test(html: String) {
        return getTextData(html)
    }

    fun parseFromFile(path: String): String {
        val file = File(System.getProperty("user.dir") + "/" + path)

        val doc = Jsoup.parse(file, "UTF-8")
        val title = doc.selectFirst("h1")
        var textBuilder = StringBuilder()

        val text = TextFilter.filter(doc.select("p"))

        for (part in text) {
            textBuilder.append(part.text())
        }

        println(textBuilder.toString())

        return title!!.text()
    }

    fun parseAllFiles(dir: String) {
        val conf = Configuration()
        val fs: FileSystem = FileSystem.get(URI("/"), conf)
        val fileStatus: Array<FileStatus> = fs.listStatus(Path("/"))
        for (status in fileStatus) {
            val halfDest = status.getPath().toString()
            val path = halfDest.split("")
        }
    }

    fun getSearchResults(q: String): SearchResults {

        val searchUrl = StringBuilder().append("https://google.com/search?q=").append(q.replace(" ", "%20")).toString()
        val doc = Jsoup.connect(searchUrl)
            .timeout(getTimeout())
            .userAgent(USER_AGENT)
            .get()

        println(searchUrl)
        val results = SearchResults()
        for (result in doc.select("a > h3")) {

            val title = result.text()
            val url = StringBuilder()
                .append("https://google.com")
                .append(result.parent()?.attr("href"))
                .toString()

//            results.add(SearchResult(title, hashMapOf("key" to "value", "foo" to "bar")))
        }

        return results
    }

    private fun getTextData(html: String) {
        val doc = Jsoup.parse(html)
        println(doc.text())
    }

    private fun getTimeout(): Int {
        return TIMEOUT * 1000
    }

}