package com.ddanilov.composeapp.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.ddanilov.composeapp.RootComponent

@Composable
fun HomeRoute(component: HomeComponent) {

}

@Composable
private fun BottomNavigation(
    activeComponent: HomeComponent.Child,
    component: HomeComponent,
    modifier: Modifier = Modifier
) {
    androidx.compose.material.BottomNavigation(modifier = modifier) {
        BottomNavigationItem(
            selected = activeComponent is HomeComponent.Child.Artists,
            onClick = { component.onTabClick(HomeComponent.Tab.Artists) },
            icon = {
                Icon(
                    imageVector = Icons.Default.MailOutline,
                    contentDescription = "Artists",
                )
            },
        )

        BottomNavigationItem(
            selected = activeComponent is HomeComponent.Child.Albums,
            onClick = { component.onTabClick(HomeComponent.Tab.Albums) },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Info,
                    contentDescription = "Albums",
                )
            }
        )
    }
}
