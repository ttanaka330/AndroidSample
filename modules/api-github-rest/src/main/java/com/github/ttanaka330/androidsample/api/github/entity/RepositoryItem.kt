package com.github.ttanaka330.androidsample.api.github.entity

import com.github.ttanaka330.androidsample.api.github.serializer.DateAsStringSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class RepositoryItem(
    @SerialName("id")
    val id: Int,
    @SerialName("node_id")
    val nodeId: String,
    @SerialName("name")
    val name: String,
    @SerialName("full_name")
    val fullName: String,
    @SerialName("owner")
    val owner: Owner,
    @SerialName("private")
    val private: Boolean,
    @SerialName("html_url")
    val htmlUrl: String,
    @SerialName("description")
    val description: String,
    @SerialName("fork")
    val fork: Boolean?,
    @SerialName("url")
    val url: String?,
    @Serializable(with = DateAsStringSerializer::class)
    @SerialName("created_at")
    val createdAt: Date?,
    @Serializable(with = DateAsStringSerializer::class)
    @SerialName("updated_at")
    val updatedAt: Date?,
    @Serializable(with = DateAsStringSerializer::class)
    @SerialName("pushed_at")
    val pushedAt: Date?,
    @SerialName("homepage")
    val homepage: String?,
    @SerialName("size")
    val size: Int?,
    @SerialName("stargazers_count")
    val stargazersCount: Int?,
    @SerialName("watchers_count")
    val watchersCount: Int?,
    @SerialName("language")
    val language: String?,
    @SerialName("forks_count")
    val forksCount: Int?,
    @SerialName("open_issues_count")
    val openIssuesCount: Int?,
    @SerialName("master_branch")
    val masterBranch: String?,
    @SerialName("default_branch")
    val defaultBranch: String?,
    @SerialName("score")
    val score: Double?,
    @SerialName("archive_url")
    val archiveUrl: String?,
    @SerialName("assignees_url")
    val assigneesUrl: String?,
    @SerialName("blobs_url")
    val blobsUrl: String?,
    @SerialName("branches_url")
    val branchesUrl: String?,
    @SerialName("collaborators_url")
    val collaboratorsUrl: String?,
    @SerialName("comments_url")
    val commentsUrl: String?,
    @SerialName("commits_url")
    val commitsUrl: String?,
    @SerialName("compare_url")
    val compareUrl: String?,
    @SerialName("contents_url")
    val contentsUrl: String?,
    @SerialName("contributors_url")
    val contributorsUrl: String?,
    @SerialName("deployments_url")
    val deploymentsUrl: String?,
    @SerialName("downloads_url")
    val downloadsUrl: String?,
    @SerialName("events_url")
    val eventsUrl: String?,
    @SerialName("forks_url")
    val forksUrl: String?,
    @SerialName("git_commits_url")
    val gitCommitsUrl: String?,
    @SerialName("git_refs_url")
    val gitRefsUrl: String?,
    @SerialName("git_tags_url")
    val gitTagsUrl: String?,
    @SerialName("git_url")
    val gitUrl: String?,
    @SerialName("issue_comment_url")
    val issueCommentUrl: String?,
    @SerialName("issue_events_url")
    val issueEventsUrl: String?,
    @SerialName("issues_url")
    val issuesUrl: String?,
    @SerialName("keys_url")
    val keysUrl: String?,
    @SerialName("labels_url")
    val labelsUrl: String?,
    @SerialName("languages_url")
    val languagesUrl: String?,
    @SerialName("merges_url")
    val mergesUrl: String?,
    @SerialName("milestones_url")
    val milestonesUrl: String?,
    @SerialName("notifications_url")
    val notificationsUrl: String?,
    @SerialName("pulls_url")
    val pullsUrl: String?,
    @SerialName("releases_url")
    val releasesUrl: String?,
    @SerialName("ssh_url")
    val sshUrl: String?,
    @SerialName("stargazers_url")
    val stargazersUrl: String?,
    @SerialName("statuses_url")
    val statusesUrl: String?,
    @SerialName("subscribers_url")
    val subscribersUrl: String?,
    @SerialName("subscription_url")
    val subscriptionUrl: String?,
    @SerialName("tags_url")
    val tagsUrl: String?,
    @SerialName("teams_url")
    val teamsUrl: String?,
    @SerialName("trees_url")
    val treesUrl: String?,
    @SerialName("clone_url")
    val cloneUrl: String?,
    @SerialName("mirror_url")
    val mirrorUrl: String?,
    @SerialName("hooks_url")
    val hooksUrl: String?,
    @SerialName("svn_url")
    val svnUrl: String?,
    @SerialName("forks")
    val forks: Int?,
    @SerialName("open_issues")
    val openIssues: String?,
    @SerialName("watchers")
    val watchers: String?,
    @SerialName("has_issues")
    val hasIssues: Boolean?,
    @SerialName("has_projects")
    val hasProjects: Boolean?,
    @SerialName("has_pages")
    val hasPages: Boolean?,
    @SerialName("has_wiki")
    val hasWiki: Boolean?,
    @SerialName("has_downloads")
    val hasDownloads: String?,
    @SerialName("archived")
    val archived: Boolean?,
    @SerialName("disabled")
    val disabled: Boolean?,
    @SerialName("visibility")
    val visibility: String?,
    @SerialName("license")
    val license: String?
)
