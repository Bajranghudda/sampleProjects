package com.example.sadidotcom.koin

import com.example.sadidotcom.BuildConfig
import com.example.sadidotcom.data.database.PersonDao
import com.example.sadidotcom.data.model.api.RemoteDataSource
import com.example.sadidotcom.data.model.api.ApiService
import com.example.sadidotcom.data.model.repository.PersonRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TIME_OUT = 30L

val retrofitModule = module {
    single { createService(get()) }
    single { createRetrofit(get(), BuildConfig.BASE_URL) }
    single { createOkHttpClient() }
    single { GsonConverterFactory.create() }
    single { createApiHelper(get()) }
}

fun createService(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}

fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}

fun createPersonRepository(remoteDataSource: RemoteDataSource, personDao: PersonDao): PersonRepository {
    return PersonRepository(remoteDataSource, personDao)
}

fun createApiHelper(apiService: ApiService): RemoteDataSource {
    return RemoteDataSource(apiService)
}