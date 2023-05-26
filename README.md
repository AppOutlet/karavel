# ⛵️Karavel

[![Maintainability](https://api.codeclimate.com/v1/badges/ea792fdab9ab8344cb1c/maintainability)](https://codeclimate.com/github/app-outlet/karavel/maintainability)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.app-outlet/karavel.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22io.github.app-outlet%22%20AND%20a:%22karavel%22)

Karavel is a very simple and lightweight navigation library for Compose for Desktop. It creates a stack of composables and let you navigate poping and pushing on this stack. 

## Discontinued
Karavel was discontinued. We recomment alternative libraries to setup your navigation in a Jetpack compose app. Our recommentation is to use [Voyager](https://voyager.adriel.cafe/).

## Install
Add the dependency on you `build.gradle.kts` file
```kotlin
dependencies {
    // ...
    implementation("io.github.app-outlet:karavel:<version>")
}
```

## Usage
```kotlin
import androidx.compose.runtime.Composable
import io.appoutlet.karavel.Page

// 1.  Extends the Page class
class MainPage : Page() {
    
    // 2. Override the content() method and annotate it with composable
    @Composable
    override fun content() {
        // ...Page content...
    }
}
```

```kotlin
fun main() = application {
    Window(onCloseRequest = ::exitApplication) {

        // 3. Create karavel instance passing the main page as argument
        val karavel = Karavel(MainPage())

        MaterialTheme {
            // 4. Get the current page content
            karavel.currentPage().content()
        }
    }
}
```

```kotlin
    @Composable
    override fun content() {
        Button(onClick = {
            // 5. use the karavel object to navigate
            karavel?.navigate(SettingsPage())
        }) {
            Text("Go to settings page")
        }
        
        Button(onClick = {
            // 6. use the karavel object to back to the previous screen
            karavel?.back()
        }) {
            Text("Back to previous screen")
        }
    }
```

## License

MIT License

Copyright (c) 2021 App Outlet

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
