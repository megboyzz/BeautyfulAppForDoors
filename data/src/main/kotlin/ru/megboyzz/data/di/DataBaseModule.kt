package ru.megboyzz.data.di


import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.megboyzz.data.db.AppDataBase
import javax.inject.Singleton


@Module
class DataBaseModule(private val context: Context) {

    @Singleton
    @Provides
    fun providesDb() : AppDataBase =
        Room.databaseBuilder(context,
            AppDataBase::class.java, "app.db").build()

}