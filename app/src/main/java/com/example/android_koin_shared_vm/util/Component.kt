package com.example.android_koin_shared_vm.util

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun Column(content: @Composable ColumnScope.() -> Unit) {
    androidx.compose.foundation.layout.Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        content = content
    )
}