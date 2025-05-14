package stevens.software.wordoftheday.data

class WordsRepository(
    val wordsDataSource: WordsDataSource
) {
    fun getRandomWord() : WordAndMeaning {
        return wordsDataSource.getAllWords().random()
    }
}