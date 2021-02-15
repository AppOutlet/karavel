# karavel
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
