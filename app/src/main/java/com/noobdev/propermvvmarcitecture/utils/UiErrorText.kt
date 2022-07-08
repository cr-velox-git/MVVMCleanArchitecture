package com.noobdev.propermvvmarcitecture.utils

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class UiErrorText {

    data class DynamicString(val errorMessage: String) : UiErrorText()
    data class StringResource(
        @StringRes val id: Int,
        val args: Array<Any> = emptyArray()
    ) : UiErrorText()

    @Composable
    fun asString(): String {
        return when (this) {
            is DynamicString -> errorMessage
            is StringResource -> stringResource(id, args)
        }
    }

}