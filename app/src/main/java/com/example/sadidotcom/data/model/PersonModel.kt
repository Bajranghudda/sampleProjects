package com.example.sadidotcom.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

data class PersonModel(
    val info: Info,
    val results: List<Person>
)

data class Info(
    val page: Int,
    val results: Int,
    val seed: String,
    val version: String
)

@Entity(tableName = "people")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val personId: Long,
    val cell: String,
    @Embedded
    val dob: Dob,
    val email: String,
    val gender: String,
    @Embedded
    val id: Id,
    @Embedded
    val location: Location,
    @Embedded
    val login: Login,
    @Embedded
    val name: Name,
    val nat: String,
    val phone: String,
    @Embedded
    val picture: Picture,
    @Embedded
    val registered: Registered,
    var isDeclined: Boolean,
    var isChangeDone: Boolean = false
)

data class Dob(
    val age: Int,
    val date: String
)

data class Id(
    val name: String,
    val value: String? = ""
)

data class Location(
    val city: String,
    @Embedded
    val coordinates: Coordinates,
    val country: String,
    val postcode: String? = "",
    val state: String,
    @Embedded
    val street: Street,
    @Embedded
    val timezone: Timezone
)

data class Login(
    val md5: String,
    val password: String,
    val salt: String,
    val sha1: String,
    val sha256: String,
    val username: String,
    val uuid: String
)

data class Name(
    val first: String,
    val last: String,
    val title: String
)

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)

data class Registered(
    @ColumnInfo(name = "registered_age")
    val age: Int,
    @ColumnInfo(name = "registered_date")
    val date: String
)

data class Coordinates(
    val latitude: String,
    val longitude: String
)

data class Street(
    @ColumnInfo(name = "street_name")
    val name: String,
    val number: Int
)

data class Timezone(
    val description: String,
    val offset: String
)