package com.ddanilov.composeapp

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.ddanilov.androidmultiplatformapp.initKoin
import com.ddanilov.composeapp.home.HomeRoute
import com.ddanilov.composeapp.theme.AppTheme
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin(networkLoggingEnabled = BuildConfig.DEBUG) {
            androidContext(this@App)
            if (BuildConfig.DEBUG) {
                androidLogger(Level.DEBUG)
            }
        }
    }
}

class AppActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        val root = DefaultRootComponent(defaultComponentContext())
        setContent {
            AppTheme {
                RootScreen(root)
            }
        }
    }
}

@Composable
internal fun RootScreen(component: RootComponent) {
    val childStack by component.stack.subscribeAsState()
    Children(
        stack = childStack,
        modifier = Modifier.fillMaxSize()
    ) {
        HomeRoute(it.instance.component)
    }
}
