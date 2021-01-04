package com.example.sadidotcom.koin

import com.example.sadidotcom.ui.main.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { MainViewModel(get()) }

    single { createPersonRepository(get(), get()) }
}