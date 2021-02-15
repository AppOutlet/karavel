package io.appoutlet.karavel

import androidx.compose.runtime.Composable

abstract class Page {
    var karavel: Karavel? = null

    @Composable
    abstract fun content()
}