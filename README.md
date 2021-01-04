Bajrang Hudda Catalog
=========================

This app illustrating current Android Architecture state using Android development best
practices.

[To get started you can find project and Architecture overview in the Medium article](https://medium.com/@eli.fox/android-architecture-starring-kotlin-coroutines-jetpack-mvvm-room-paging-retrofit-and-dagger-7749b2bae5f7?sk=9c5a7af2fbf5d4a04e72322bfb245489). 

Introduction
------------

The application uses Clean Architecture based on MVVM and Repository patterns. Implemented
Architecture principles follow Google recommended [Guide to app architecture](https://developer.android.com/jetpack/docs/guide).

![Guide to app architecture](screenshots/guide-to-app-architecture.png "Guide to app architecture")

The application is written entirely in Kotlin.

Android Jetpack is used as an Architecture glue including but not limited to ViewModel, LiveData,
Lifecycles, Room and Data Binding.

The application does network HTTP requests via Retrofit, OkHttp and GSON. Loaded data is saved to
SQL based database Room, which serves as single source of truth and support offline mode.
In future I will be using Paging library for data pagination online and offline.

Kotlin Coroutines manage background threads with simplified code and reducing needs for callbacks.
Combination of Coroutines and Kotlin build in functions (transformation, collections) are preferred
over RxJava 2.

Work manager does synchronisation job being compatible with Doze Mode and using battery efficiently.
In furtur I will implement Navigation component for in-app navigation.

Koin is used for dependency injection.

Picasso is used for image loading.

Room is used for offile storage.


A sample app consist of 1 screen: List of card same as sadi dot com. Each card having 2 button Accept & Decline - If clicked on anyone save it's state on local and show a message Member accepted/ declined. 
