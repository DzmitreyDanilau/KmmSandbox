package com.ddanilov.androidmultiplatformapp

import com.aibuy.shared.network.httpEngine
import org.koin.dsl.module

actual fun platformModule() = module {
    single { httpEngine }
}
