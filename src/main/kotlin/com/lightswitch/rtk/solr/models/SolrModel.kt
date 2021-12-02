package com.lightswitch.rtk.solr.models

import org.apache.solr.client.solrj.beans.Field

enum class Source {
    VK, INST, OTHER
}

data class SolrModel(
    @Field var id: String,
    @Field var source: Source,
    @Field var url: String,
) {


}