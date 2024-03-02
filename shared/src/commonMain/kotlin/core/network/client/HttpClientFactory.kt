package core.network.client

import io.ktor.client.HttpClient

expect class HttpClientFactory {
    fun create(): HttpClient
}