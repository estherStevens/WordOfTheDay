package stevens.software.wordoftheday.ui

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.koin.androidx.compose.koinViewModel
import stevens.software.wordoftheday.R
import stevens.software.wordoftheday.montserratFontFamily
import stevens.software.wordoftheday.poltawskinowyFontFamily
import java.util.Locale

@Composable
fun WordOfTheDayScreen(
    viewModel: WordOfTheDayViewModel = koinViewModel()
) {
    val uiState = viewModel.uiState.collectAsState()

    val context = LocalContext.current
    val textToSpeech = TextToSpeech(context, object : TextToSpeech.OnInitListener {
        override fun onInit(status: Int) {}
    })

    textToSpeech.language = uiState.value?.locale

    WordOfTheDayView(
        word = uiState.value?.word?.word ?: "",
        meaning = uiState.value?.word?.meaning ?: "",
        onSpeakClicked = {
            if(textToSpeech.isSpeaking){
                textToSpeech.stop()
            } else {
                textToSpeech.speak(uiState.value?.word?.word,
                    TextToSpeech.QUEUE_ADD,
                    null,
                    "0"
                )
                textToSpeech.speak(uiState.value?.word?.meaning,
                    TextToSpeech.QUEUE_ADD,
                    null,
                    "1"
                )
            }
        }
    )
}

@Composable
fun WordOfTheDayView(
    word: String,
    meaning: String,
    onSpeakClicked: () -> Unit
){
    val gradientBrush = Brush.verticalGradient(
        listOf(
            colorResource(R.color.background_gradient1),
            colorResource(R.color.background_gradient2),
            colorResource(R.color.background_gradient3)
        )
    )
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBrush),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(364.dp)
                    .padding(horizontal = 24.dp),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors().copy(
                    containerColor = colorResource(R.color.card_bg)
                )
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(horizontal = 32.dp)
                ) {
                    Text(
                        text = word,
                        fontFamily = poltawskinowyFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 38.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(Modifier.size(12.dp))
                    Text(
                        text = meaning,
                        fontFamily = montserratFontFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 19.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(Modifier.size(40.dp))
            Button(
                onClick = onSpeakClicked,
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors().copy(
                    containerColor = colorResource(R.color.button)
                ),
                modifier = Modifier.size(84.dp)
            ) {
                Image(
                    contentDescription = null,
                    painter = painterResource(R.drawable.volume_icon)
                )
            }
        }

    }
}

@Preview
@Composable
fun WordOfTheDayPreview() {
    MaterialTheme {
        WordOfTheDayScreen()
    }
}