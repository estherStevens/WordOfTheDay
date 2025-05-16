package stevens.software.wordoftheday.ui

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import stevens.software.wordoftheday.data.WordAndMeaning
import stevens.software.wordoftheday.data.WordsRepository
import java.util.Locale

class WordOfTheDayViewModel(
    private val wordsRepository: WordsRepository
): ViewModel() {

    private val _uiState: MutableStateFlow<WordOfTheDayUiState?> = MutableStateFlow<WordOfTheDayUiState?>(null)
    val uiState = _uiState.asStateFlow()

    init {
        val randomWord = wordsRepository.getRandomWord()

        _uiState.update {
            WordOfTheDayUiState(
                word = randomWord,
                locale = Resources.getSystem().configuration.getLocales().get(0))
        }
    }

}

data class WordOfTheDayUiState(
    val word: WordAndMeaning?,
    val locale: Locale
)