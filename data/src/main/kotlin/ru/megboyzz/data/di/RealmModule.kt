package ru.megboyzz.data.di

import dagger.Module
import dagger.Provides
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import ru.megboyzz.data.db.entities.CameraRealm
import ru.megboyzz.data.db.entities.DoorRealm
import javax.inject.Singleton


@Module
class RealmModule {

    @Provides
    fun providesRealmConfiguration(): RealmConfiguration = RealmConfiguration
        .Builder(schema = setOf(CameraRealm::class, DoorRealm::class))
        .deleteRealmIfMigrationNeeded()
        .schemaVersion(0)
        .build()


    @Provides
    @Singleton
    fun providesRealm(config: RealmConfiguration): Realm = Realm.open(config)

}