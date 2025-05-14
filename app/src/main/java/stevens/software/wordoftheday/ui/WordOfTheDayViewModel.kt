package stevens.software.wordoftheday.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import stevens.software.wordoftheday.data.WordAndMeaning
import stevens.software.wordoftheday.data.WordsRepository

class WordOfTheDayViewModel(
    private val wordsRepository: WordsRepository
): ViewModel() {

    private val _uiState: MutableStateFlow<WordOfTheDayUiState?> = MutableStateFlow<WordOfTheDayUiState?>(null)
    val uiState = _uiState.asStateFlow()

    init {
        val randomWord = wordsRepository.getRandomWord()
        _uiState.update {
            WordOfTheDayUiState(randomWord)
        }
    }

}

data class WordOfTheDayUiState(
    val word: WordAndMeaning?
)