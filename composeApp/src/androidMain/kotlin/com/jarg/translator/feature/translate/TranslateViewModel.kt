package com.jarg.translator.feature.translate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import core.domain.history.repository.HistoryDataSource
import core.domain.translate.useCase.TranslateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import feature.translate.TranslateViewModel
import feature.translate.model.TranslateEvent
import javax.inject.Inject

@HiltViewModel
class TranslateViewModel @Inject constructor(
    private val translateUseCase: TranslateUseCase,
    private val historyDataSource: HistoryDataSource
): ViewModel() {

    private val viewModel by lazy {
        TranslateViewModel(
            translateUseCase = translateUseCase,
            historyDataSource = historyDataSource,
            coroutineScope = viewModelScope
        )
    }

    val state = viewModel.state

    fun onEvent(event: TranslateEvent) {
        viewModel.onEvent(event)
    }

}