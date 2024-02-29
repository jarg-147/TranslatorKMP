package core.domain.history.repository

import core.common.utils.CommonFlow
import core.domain.history.model.HistoryItem

interface HistoryDataSource {
    fun getHistory(): CommonFlow<List<HistoryItem>>
    suspend fun insertHistoryItem(item: HistoryItem)
}