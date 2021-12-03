package com.lightswitch.rtk.solr

import com.lightswitch.rtk.parser.SearchResults
import com.lightswitch.rtk.solr.models.SolrModel
import com.lightswitch.rtk.solr.models.Source
import org.apache.solr.client.solrj.SolrClient
import org.apache.solr.client.solrj.SolrQuery
import org.apache.solr.client.solrj.SolrServerException
import org.apache.solr.client.solrj.impl.HttpSolrClient
import org.apache.solr.client.solrj.response.QueryResponse
import org.apache.solr.common.SolrDocument
import org.apache.solr.common.SolrDocumentList
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.io.PrintStream
import java.util.*

object SolrService {

    private val client: HttpSolrClient = HttpSolrClient.Builder("http://localhost:8983/solr/rtk").build()
    private val Log: Logger = LoggerFactory.getLogger(SolrService::class.java)

    fun indexModels(models: MutableList<SolrModel>) {
        try {

            client.addBeans(models)
            client.commit(true, true)

        } catch (e: Exception) {
            Log.error(e.toString())
        }
    }

    fun test() {

        val model1 = SolrModel("1", Source.VK.toString(), "vk.com/sireax")
        val model2 = SolrModel("2", Source.OTHER.toString(), "vc.ru/post/lk234soiujsdf")

        SolrService.indexModels(mutableListOf(model1, model2))

    }

    @Throws(SolrServerException::class)
    fun simpleSolrQuery(
        solr: SolrClient,
        query: String?, rows: Int
    ): SolrDocumentList {
        val solrQuery = SolrQuery(query)
        solrQuery.rows = rows
        val resp: QueryResponse = solr.query(solrQuery)
        return resp.results
    }

    fun prettyPrint(out: PrintStream, doc: SolrDocument) {
        val sortedFieldNames: List<String> = ArrayList(doc.fieldNames)
        Collections.sort(sortedFieldNames)
        out.println()
        for (field in sortedFieldNames) {
            out.println(
                String.format(
                    "\t%s: %s",
                    field, doc.getFieldValue(field)
                )
            )
        }
        out.println()
    }

    object Search {

        fun search(): SearchResults {
            var results = SearchResults()

            val source = "source:${Source.VK}"
            println(source)
            val query = SolrQuery("*:*")
            query.addFilterQuery(source)
//            query.start = 0

            val response = client.query(query)

            for (result in response.results) {
                val url = result.getFieldValue("url")
                println(url)
//                results.add(SearchResult("test sdfsd", hashMapOf("url" to url.toString())))
            }

            return results

        }

    }

}