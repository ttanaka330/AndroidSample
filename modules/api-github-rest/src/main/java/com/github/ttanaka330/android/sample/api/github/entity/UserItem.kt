package com.github.ttanaka330.android.sample.api.github.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserItem(
    @SerialName("login")
    val login: String,
    @SerialName("id")
    val id: Int,
    @SerialName("node_id")
    val nodeId: String,
    @SerialName("avatar_url")
    val avatarUrl: String,
    @SerialName("gravatar_id")
    val gravatarId: String,
    @SerialName("url")
    val url: String,
    @SerialName("html_url")
    val htmlUrl: String,
    @SerialName("followers_url")
    val followersUrl: String?,
    @SerialName("subscriptions_url")
    val subscriptionsUrl: String?,
    @SerialName("organizations_url")
    val organizationsUrl: String?,
    @SerialName("repos_url")
    val reposUrl: String?,
    @SerialName("received_events_url")
    val receivedEventsUrl: String?,
    @SerialName("type")
    val type: String?,
    @SerialName("score")
    val score: Double?,
    @SerialName("following_url")
    val followingUrl: String?,
    @SerialName("gists_url")
    val gistsUrl: String?,
    @SerialName("starred_url")
    val starredUrl: String?,
    @SerialName("events_url")
    val eventsUrl: String?,
    @SerialName("site_admin")
    val siteAdmin: Boolean?
)
