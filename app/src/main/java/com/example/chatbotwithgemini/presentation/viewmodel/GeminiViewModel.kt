package com.example.chatbotwithgemini.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.chatbotwithgemini.core.constants.Constants
import com.example.chatbotwithgemini.BuildConfig
import com.google.ai.client.generativeai.GenerativeModel

class GeminiViewModel : ViewModel() {

    private val generativeModel = GenerativeModel(
        modelName = Constants.MODEL_NAME,
        apiKey = BuildConfig.API_KEY
    )

}