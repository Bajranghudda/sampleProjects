package com.example.sadidotcom.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sadidotcom.data.model.Person

@Dao
interface PersonDao {
    @Query("SELECT * FROM people")
    fun getPeople(): LiveData<List<Person>>

    /*@Query("SELECT * FROM people")
    suspend fun getPagedPeople(): DataSource.Factory<Int, Person>*/

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(people: List<Person>)

    @Query("UPDATE people SET isChangeDone=:isChangeDone, isDeclined=:isDeclined  WHERE personId = :personId")
    suspend fun updateCard(isDeclined: Boolean, isChangeDone: Boolean = true, personId: Long)

    @Query("DELETE FROM people")
    suspend fun clear()
}