package com.github.ttanaka330.androidsample.model

import com.github.ttanaka330.androidsample.values.UserAccount
import com.github.ttanaka330.androidsample.values.UserId

/**
 * ユーザ情報
 *
 * @param id ID
 * @param account アカウント
 * @param name ユーザ名
 * @param pageUrl ユーザーページURL
 * @param iconUrl アイコン画像URL
 */
data class UserInfo(
    val id: UserId,
    val account: UserAccount,
    val name: String,
    val pageUrl: String,
    val iconUrl: String
)
