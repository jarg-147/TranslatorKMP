package com.jarg.translator.app.di

import core.domain.history.repository.HistoryDataSource
import core.domain.translate.repository.TranslateDataSource
import core.domain.translate.useCase.TranslateUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideTranslateUseCase(
        client: TranslateDataSource,
        dataSource: HistoryDataSource
    ): TranslateUseCase = TranslateUseCase(client = client, historyDataSource = dataSource)

}