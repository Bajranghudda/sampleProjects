package com.example.sadidotcom.data.model.repository

import com.example.sadidotcom.data.database.PersonDao
import com.example.sadidotcom.data.model.api.RemoteDataSource
import com.example.sadidotcom.data.resultLiveData

class PersonRepository(
    private val remoteDataSource: RemoteDataSource,
    private val personDao: PersonDao
) {

    val people = resultLiveData(
        databaseQuery = { personDao.getPeople() },
        networkCall = { remoteDataSource.getItems() },
        saveCallResult = { personDao.insertAll(it.results) })

    suspend fun updateCard(isDeclined: Boolean, isChangeDone: Boolean = true, personId: Long){
        personDao.updateCard(isDeclined, isChangeDone, personId)
    }
}