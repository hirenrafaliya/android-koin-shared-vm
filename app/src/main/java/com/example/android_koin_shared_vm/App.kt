package com.example.android_koin_shared_vm

import android.app.Application
import com.example.android_koin_shared_vm.viewmodel.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        val appModule = module {
            viewModel { MainViewModel() }
        }

        startKoin {
            androidContext(this@App)
            modules(appModule)
        }
    }
}

