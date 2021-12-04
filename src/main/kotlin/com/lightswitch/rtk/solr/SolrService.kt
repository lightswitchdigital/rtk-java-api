package com.lightswitch.rtk.solr

import com.lightswitch.rtk.parser.SearchResults
import com.lightswitch.rtk.solr.models.SolrModel
import com.lightswitch.rtk.solr.models.Source
import org.apache.solr.client.solrj.SolrClient
import org.apache.solr.client.solrj.SolrQuery
import org.apache.solr.client.solrj.SolrServerException
import org.apache.solr.client.solrj.impl.HttpSolrClient
import org.apache.solr.client.solrj.response.QueryResponse
import org.apache.solr.common.SolrDocumentList
import org.slf4j.Logger
import org.slf4j.LoggerFactory

// Сервис для взаимодействия с SolR
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