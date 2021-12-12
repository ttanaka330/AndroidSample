package com.github.ttanaka330.android.sample.model

import com.github.ttanaka330.android.sample.values.UserAccount
import com.github.ttanaka330.android.sample.values.UserId

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
