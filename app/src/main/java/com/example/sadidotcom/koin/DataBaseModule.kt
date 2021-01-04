package com.example.sadidotcom.koin

import com.example.sadidotcom.data.database.AppDatabase
import com.example.sadidotcom.data.database.PersonDao
import org.koin.dsl.module

val dataBaseModule = module {
    single { AppDatabase.getInstance(get()) }
    single { AppDatabase.getInstance(get()).personDao()  }
}