package core.domain.translate.repository

import core.common.utils.CommonFlow
import core.domain.language.model.Language

interface TranslateDataSource {
    suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): CommonFlow<String>
}