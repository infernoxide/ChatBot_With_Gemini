package com.example.chatbotwithgemini.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatbotwithgemini.core.constants.Constants
import com.example.chatbotwithgemini.BuildConfig
import com.example.chatbotwithgemini.domain.model.MessageModel
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.launch

class GeminiViewModel : ViewModel() {

    private val generativeModel = GenerativeModel(
        modelName = Constants.MODEL_NAME,
        apiKey = BuildConfig.API_KEY
    )
    private val chat by lazy {
        generativeModel.startChat()
    }
    val messageList by lazy {
        mutableStateListOf<MessageModel>()
    }

    fun sendMessage(question:String){
        viewModelScope.launch {
            try {
                messageList.add(MessageModel(question, Constants.ROLE_USER))
                val response = chat.sendMessage(question)
                messageList.add(MessageModel(response.text.toString(), Constants.ROLE_MODEL))
            }
            catch (e: Exception){
                messageList.add(MessageModel(Constants.ERROR_IN_CONVERSATION+e, Constants.ROLE_MODEL))
            }
        }
    }

}