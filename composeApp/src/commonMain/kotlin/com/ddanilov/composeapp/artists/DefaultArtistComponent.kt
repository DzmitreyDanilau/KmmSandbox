package com.ddanilov.composeapp.artists

import com.arkivanov.decompose.ComponentContext

class DefaultArtistsComponent(
    componentContext: ComponentContext
) : ArtistComponent, ComponentContext by componentContext {

}
