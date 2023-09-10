package com.ddanilov.composeapp

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.ddanilov.composeapp.home.HomeComponent

interface RootComponent {

    val stack: Value<ChildStack<*, Home>>

    fun onBackClicked()

    data class Home(val component: HomeComponent)
}
