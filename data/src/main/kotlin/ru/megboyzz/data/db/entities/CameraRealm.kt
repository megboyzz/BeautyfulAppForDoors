package ru.megboyzz.data.db.entities

import io.realm.kotlin.Realm
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId


data class CameraRealm(
    @PrimaryKey
    val id: Int,
    var name: String,
    val snapshot: String,
    val room: String?,
    var favorites: Boolean,
    val rec: Boolean
) : RealmObject