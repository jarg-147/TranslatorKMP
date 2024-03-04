package com.jarg.translator.app.di

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import com.jarg.translator.database.TranslatorDatabase
import core.data.history.repository.HistoryRepository
import core.data.local.DatabaseDriverFactory
import core.data.translate.repository.TranslateRepository
import core.domain.history.repository.HistoryDataSource
import core.domain.translate.repository.TranslateDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideDatabaseDriver(@ApplicationContext context: Context): SqlDriver {
        return DatabaseDriverFactory(context).create()
    }

    @Provides
    @Singleton
    fun provideTranslateRepository(httpClient: HttpClient): TranslateDataSource {
        return TranslateRepository(httpClient)
    }

    @Provides
    @Singleton
    fun provideHistoryDataSource(driver: SqlDriver): HistoryDataSource {
        return HistoryRepository(TranslatorDatabase(driver))
    }

}