package com.ddanilov.androidmultiplatformapp

sealed class KMPResult<out T>(open val value: T?)

data class KMPResultSuccess<T>(override val value: T) : KMPResult<T>(value)

data class KMPResultFailure(val exception: Throwable) : KMPResult<Nothing>(null)
