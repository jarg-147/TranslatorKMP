package core.domain.translate.useCase

import core.domain.history.model.HistoryItem
import core.domain.history.repository.HistoryDataSource
import core.domain.language.model.Language
import core.domain.translate.repository.TranslateDataSource
import kotlinx.coroutines.flow.*

class TranslateUseCase(
    private val client: TranslateDataSource,
    private val historyDataSource: HistoryDataSource
) {

    suspend operator fun invoke(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): Flow<String> = flow {
        client.translate(
            fromLanguage = fromLanguage,
            fromText = fromText,
            toLanguage = toLanguage
        ).map { translatedText ->
            historyDataSource.insertHistoryItem(
                HistoryItem(
                    id = null,
                    fromLanguageCode = fromLanguage.langCode,
                    fromText = fromText,
                    toLanguageCode = toLanguage.langCode,
                    toText = translatedText,
                )
            )
            emit(translatedText)
        }.collect()
    }

}