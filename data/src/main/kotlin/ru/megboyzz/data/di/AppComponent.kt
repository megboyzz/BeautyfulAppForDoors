package ru.megboyzz.data.di

import dagger.Component

@Component(modules = [NetworkModule::class, RealmModule::class])
interface AppComponent {

    

}