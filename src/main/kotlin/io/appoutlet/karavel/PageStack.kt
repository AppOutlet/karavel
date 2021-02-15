package io.appoutlet.karavel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.util.Stack

class PageStack(rootPage: Page) {
    private var currentPage by mutableStateOf(rootPage)

    private val pageStack = Stack<Page>().apply {
        push(rootPage)
    }

    fun push(page: Page) {
        pageStack.push(page)
        currentPage = page
    }

    fun pop() {
        pageStack.pop()
        currentPage = pageStack.peek()
    }

    fun peek() = currentPage
}