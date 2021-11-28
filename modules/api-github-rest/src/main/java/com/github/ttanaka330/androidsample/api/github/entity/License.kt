package com.github.ttanaka330.androidsample.api.github.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class License(
    @SerialName("key")
    val key: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("url")
    val url: String?,
    @SerialName("spdx_id")
    val spdxId: String?,
    @SerialName("node_id")
    val nodeId: String?,
    @SerialName("html_url")
    val htmlUrl: String?
)
