package ua.com.andromeda.mykharkiv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ua.com.andromeda.mykharkiv.ui.theme.MyKharkivTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyKharkivTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSizeClass = calculateWindowSizeClass(activity = this)
                    MyKharkivApp(windowSizeClass.widthSizeClass)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyKharkivAppCompactPreview() {
    MyKharkivTheme {
        Surface {
            MyKharkivApp(WindowWidthSizeClass.Compact)
        }
    }
}

@Preview(showBackground = true, widthDp = 700)
@Composable
fun MyKharkivAppMediumPreview() {
    MyKharkivTheme {
        Surface {
            MyKharkivApp(WindowWidthSizeClass.Medium)
        }
    }
}

@Preview(showBackground = true, widthDp = 100)
@Composable
fun MyKharkivAppExpandedPreview() {
    MyKharkivTheme {
        Surface {
            MyKharkivApp(WindowWidthSizeClass.Expanded)
        }
    }
}

