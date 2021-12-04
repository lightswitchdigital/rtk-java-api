package com.lightswitch.rtk.solr.models

import org.apache.solr.client.solrj.beans.Field

enum class Source {
    VK, INST, OTHER
}

data class SolrModel(
    @Field var id: String,
    @Field var name: String,
    @Field var last_name: String,
    @Field var text: String,
) {


}