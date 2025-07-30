package com.example.chatbotwithgemini.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.chatbotwithgemini.presentation.theme.ChatBotWithGeminiTheme
import com.example.chatbotwithgemini.presentation.viewmodel.GeminiViewModel
import com.example.chatbotwithgemini.presentation.views.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewmodel:GeminiViewModel by viewModels()
        setContent {
            ChatBotWithGeminiTheme {
                HomeView(viewmodel)
            }
        }
    }
}