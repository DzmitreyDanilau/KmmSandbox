package com.ddanilov.composeapp.albums

import com.arkivanov.decompose.ComponentContext

class DefaultAlbumsComponent(
    componentContext: ComponentContext
) : AlbumsComponent, ComponentContext by componentContext {
}

