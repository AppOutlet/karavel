# ⛵️Karavel
[![Maintainability](https://api.codeclimate.com/v1/badges/ea792fdab9ab8344cb1c/maintainability)](https://codeclimate.com/github/app-outlet/karavel/maintainability)

Lightweight navigation library for Compose for Desktop 

## Install 

1. Add it in your root build.gradle at the end of repositories:
```gradle
	allprojects {
		repositories {
			// ...
			maven { url 'https://jitpack.io' }
		}
	}
```

2. Add the dependency
```
	dependencies {
		implementation 'com.github.User:Repo:Tag'
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
import androidx.compose.desktop.Window
import androidx.compose.material.MaterialTheme
import io.appoutlet.karavel.Karavel
import io.appoutlet.ui.page.MainPage

fun main() = Window {

    // 3. Create karavel instance passing the main page as argument
    val karavel = Karavel(MainPage())

    MaterialTheme {
        // 4. Get the current page content
        karavel.currentPage().content()
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
