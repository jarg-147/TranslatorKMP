package com.jarg.translator.feature.translate.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import feature.language.model.UiLanguage

@Composable
fun SmallLanguageIcon(
    language: UiLanguage,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier.size(25.dp),
        painter = painterResource(id = language.drawableRes),
        contentDescription = language.language.langName
    )
}