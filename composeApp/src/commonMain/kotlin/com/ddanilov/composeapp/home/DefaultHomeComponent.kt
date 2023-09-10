package com.ddanilov.composeapp.home

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import com.ddanilov.composeapp.albums.DefaultAlbumsComponent
import com.ddanilov.composeapp.artists.DefaultArtistsComponent

class DefaultHomeComponent(
    componentContext: ComponentContext
) : HomeComponent, ComponentContext by componentContext {

    private val navigation = StackNavigation<RootScreenConfig>()
    override val stack: Value<ChildStack<*, HomeComponent.Child>> = childStack(
        source = navigation,
        initialStack = { listOf(RootScreenConfig.Artists) },
        childFactory = ::child
    )

    private fun child(
        config: RootScreenConfig, componentContext: ComponentContext
    ): HomeComponent.Child {
        return when (config) {
            is RootScreenConfig.Artists -> {
                HomeComponent.Child.Artists(
                    DefaultArtistsComponent(
                        componentContext = componentContext
                    )
                )
            }

            is RootScreenConfig.Albums -> {
                HomeComponent.Child.Albums(
                    DefaultAlbumsComponent(
                        componentContext = componentContext
                    )
                )
            }
        }
    }

    override fun onTabClick(tabs: HomeComponent.Tab) {
        when (tabs) {
            HomeComponent.Tab.Albums -> navigation.bringToFront(RootScreenConfig.Albums)
            HomeComponent.Tab.Artists -> navigation.bringToFront(RootScreenConfig.Artists)
        }
    }

    override fun onBackClicked() {
        navigation.pop()
    }


    sealed interface RootScreenConfig : Parcelable {

        @Parcelize
        data object Artists : RootScreenConfig

        @Parcelize
        data object Albums : RootScreenConfig
    }
}
