package com.ddanilov.androidmultiplatformapp

import com.ddanilov.androidmultiplatformapp.network.httpEngine
import org.koin.dsl.module

actual fun platformModule() = module {
    single { httpEngine }
}
