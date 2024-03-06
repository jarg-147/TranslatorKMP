package com.jarg.translator.app.navigation.host

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jarg.translator.app.navigation.route.Screen
import com.jarg.translator.feature.translate.TranslateScreen
import com.jarg.translator.feature.translate.TranslateViewModel
import feature.translate.model.TranslateEvent

@Composable
fun TranslateNavHost(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = Screen.Translate.route
    ) {
        composable(route = Screen.Translate.route) {
            val viewModel = hiltViewModel<TranslateViewModel>()
            val state by viewModel.state.collectAsStateWithLifecycle()

            TranslateScreen(
                state = state,
                onEvent = { event ->
                    when(event) {
                        is TranslateEvent.RecordAudio -> {
                            navController.navigate(
                                Screen.VoiceToText.route + "/${state.fromLanguage.language.langCode}"
                            )
                        }
                        else -> viewModel.onEvent(event)
                    }
                }
            )
        }

        composable(
            route = Screen.VoiceToText.route + "/{languageCode}",
            arguments = listOf(
                navArgument("languageCode") {
                    type = NavType.StringType
                    defaultValue = "en"
                }
            )
        ) {
            Text(text = "Voice-to-Text")
        }
    }
}