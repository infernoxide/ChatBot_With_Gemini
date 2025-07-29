package com.example.chatbotwithgemini.presentation.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.chatbotwithgemini.presentation.viewmodel.GeminiViewModel

@Composable
fun ChatContent(modifier: Modifier, viewModel: GeminiViewModel){
    LazyColumn(
        modifier = modifier,
        reverseLayout = true
    ) {
        items(viewModel.messageList.reversed()){
            GlobeMessage(messageModel = it)
        }
    }
}