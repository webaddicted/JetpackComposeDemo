package com.webaddicted.jetpackcomposedemo.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.webaddicted.jetpackcomposedemo.utils.constant.ApiConstant

@Entity(tableName = ApiConstant.USER_INFO_TABLE)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val customId: Long = 0L,
    val badgeIcon: String?,
    val beatStatus: Boolean?,
    val comment: String?,
//    @Transient
    val lastStoreDate: String?
)