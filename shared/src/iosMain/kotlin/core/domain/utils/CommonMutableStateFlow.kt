package core.domain.utils

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

actual open class CommonMutableStateFlow<T> actual constructor(
    private val flow: MutableStateFlow<T>
): CommonStateFlow<T>(flow), MutableStateFlow<T> {

    override var value: T
        get() = super.value
        set(value) {
            flow.value = value
        }

    override val replayCache: List<T>
        get() = flow.replayCache

    override val subscriptionCount: StateFlow<Int>
        get() = flow.subscriptionCount

    override suspend fun collect(collector: FlowCollector<T>): Nothing {
        flow.collect(collector)
    }

    override fun compareAndSet(expect: T, update: T): Boolean {
        return flow.compareAndSet(expect, update)
    }

    @ExperimentalCoroutinesApi
    override fun resetReplayCache() {
        flow.resetReplayCache()
    }

    override fun tryEmit(value: T): Boolean {
        return flow.tryEmit(value)
    }

    override suspend fun emit(value: T) {
        flow.emit(value)
    }

}