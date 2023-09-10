package com.ddanilov.composeapp

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.ddanilov.composeapp.home.DefaultHomeComponent

class DefaultRootComponent(
    componentContext: ComponentContext
) : RootComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<Home>()
    override val stack: Value<ChildStack<*, RootComponent.Home>> = childStack(
        source = navigation,
        initialConfiguration = Home,
        handleBackButton = true,
        childFactory = ::createChild,
    )

    private fun createChild(
        config: Home,
        componentContext: ComponentContext
    ): RootComponent.Home {
        return RootComponent.Home(DefaultHomeComponent(componentContext))
    }

    override fun onBackClicked() {
        navigation.pop()
    }
}

@Parcelize
data object Home : Parcelable
