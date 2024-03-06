package com.jarg.translator.feature.translate.state

import android.speech.tts.TextToSpeech
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

@Composable
fun rememberTextToSpeech(): TextToSpeech {
    val context = LocalContext.current
    val tts = remember {
        TextToSpeech(context, null)
    }
    DisposableEffect(key1 = tts) {
        onDispose {
            tts.stop()
            tts.shutdown()
        }
    }
    return tts
}