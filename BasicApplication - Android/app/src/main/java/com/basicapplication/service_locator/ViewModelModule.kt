package com.basicapplication.service_locator

import com.basicapplication.ui.screens.dashboard.viewmodel.DashboardViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { DashboardViewModel(get()) }
}