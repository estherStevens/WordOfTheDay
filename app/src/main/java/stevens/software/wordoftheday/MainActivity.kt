package stevens.software.wordoftheday

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import stevens.software.wordoftheday.di.appModule
import stevens.software.wordoftheday.ui.WordOfTheDayScreen
import stevens.software.wordoftheday.ui.theme.WordOfTheDayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        startKoin {
            androidContext(this@MainActivity)
            modules(appModule)
        }
        setContent {
            WordOfTheDayTheme {
                WordOfTheDayScreen()
            }
        }
    }
}

val montserratFontFamily = FontFamily(
    Font(resId = R.font.montserrat_regular, weight = FontWeight.Normal)
)

val poltawskinowyFontFamily = FontFamily(
    Font(resId = R.font.poltawskinowy_bold, weight = FontWeight.Bold)
)