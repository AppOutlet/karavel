package io.appoutlet.karavel

import androidx.compose.runtime.Composable
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class KaravelTest {

    private val page1 = object : Page() {
        @Composable
        override fun content() {
            /*no-op*/
        }
    }

    private val page2 = object : Page() {
        @Composable
        override fun content() {
            /*no-op*/
        }
    }

    @Test
    fun `Should verify if root page is the first page`() {
        val karavel = Karavel(page1)
        assertEquals(page1, karavel.currentPage())
        assertEquals(page1.karavel, karavel)
    }

    @Test
    fun `Should navigate`() {
        val karavel = Karavel(page1)
        karavel.navigate(page2)

        assertEquals(page2, karavel.currentPage())
        assertEquals(page2.karavel, karavel)
    }

    @Test
    fun `Should back to previous page`() {
        val karavel = Karavel(page1)
        karavel.navigate(page2)
        karavel.back()

        assertEquals(page1, karavel.currentPage())
        assertEquals(karavel, karavel.currentPage().karavel)
    }
}