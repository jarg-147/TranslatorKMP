package com.jarg.translator.app.navigation.route

sealed class Screen(val route: String) {

    data object Translate : Screen("translate")
    data object VoiceToText : Screen("voice_to_text")


}
