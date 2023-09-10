package com.ddanilov.composeapp.home

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.ddanilov.composeapp.albums.AlbumsComponent
import com.ddanilov.composeapp.artists.ArtistComponent

interface HomeComponent {

    val stack: Value<ChildStack<*, Child>>

    fun onTabClick(tabs: Tab)


    enum class Tab {
        Artists, Albums
    }

    fun onBackClicked()

    sealed class Child {
        class Artists(val component: ArtistComponent) : Child()
        class Albums(val component: AlbumsComponent) : Child()
    }
}



