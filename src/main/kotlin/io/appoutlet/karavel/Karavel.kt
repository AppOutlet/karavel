package io.appoutlet.karavel

class Karavel(rootPage: Page) {
    private val pageStack = PageStack(rootPage)

    init {
        rootPage.karavel = this
    }

    fun navigate(page: Page) {
        page.karavel = this
        pageStack.push(page)
    }

    fun back() {
        pageStack.pop()
    }

    fun currentPage() = pageStack.peek()
}