package stevens.software.wordoftheday.di

import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
import stevens.software.wordoftheday.data.WordsDataSource
import stevens.software.wordoftheday.data.WordsRepository
import stevens.software.wordoftheday.ui.WordOfTheDayViewModel

val appModule = module {
    factoryOf(::WordsDataSource)
    factoryOf(::WordsRepository)
    viewModelOf(::WordOfTheDayViewModel)
}