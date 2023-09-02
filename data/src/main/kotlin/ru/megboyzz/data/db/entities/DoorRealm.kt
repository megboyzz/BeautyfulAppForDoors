package ru.megboyzz.data.db.entities

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


data class DoorRealm(
    @PrimaryKey
    val id: Int,
    var name: String,
    val snapshot: String?,
    val room: String?,
    var favorites: Boolean
) : RealmObject