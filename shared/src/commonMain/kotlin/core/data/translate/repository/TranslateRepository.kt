package core.data.translate.repository

import core.common.utils.*
import core.data.translate.model.TranslateRequest
import core.data.translate.model.TranslatedDto
import core.domain.language.model.Language
import core.domain.translate.model.TranslateError
import core.domain.translate.model.TranslateException
import core.domain.translate.repository.TranslateDataSource
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.*
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.flow.flowOf

class TranslateRepository(
    private val httpClient: HttpClient
): TranslateDataSource {

    override suspend fun translate(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): CommonFlow<String> {
        val result = try {
            httpClient.post {
                url(NetworkConstants.BASE_URL + "/translate")
                contentType(ContentType.Application.Json)
                setBody(
                    TranslateRequest(
                        textToTranslate = fromText,
                        sourceLanguageCode = fromLanguage.langCode,
                        targetLanguageCode = toLanguage.langCode
                    )
                )
            }
        } catch(e: IOException) {
            throw TranslateException(TranslateError.SERVICE_UNAVAILABLE)
        }

        when(result.status.value) {
            in 200..299 -> Unit
            500 -> throw TranslateException(TranslateError.SERVER_ERROR)
            in 400..499 -> throw TranslateException(TranslateError.CLIENT_ERROR)
            else -> throw TranslateException(TranslateError.UNKNOWN_ERROR)
        }

        return try {
            flowOf(result.body<TranslatedDto>().translatedText).toCommonFlow()
        } catch(e: Exception) {
            throw TranslateException(TranslateError.SERVER_ERROR)
        }
    }
}