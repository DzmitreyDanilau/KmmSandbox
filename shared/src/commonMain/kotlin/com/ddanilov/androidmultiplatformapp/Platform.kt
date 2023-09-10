package com.ddanilov.androidmultiplatformapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform