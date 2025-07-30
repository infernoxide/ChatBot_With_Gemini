package com.example.chatbotwithgemini.presentation.viewmodel

import android.app.Application
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.chatbotwithgemini.BuildConfig
import com.example.chatbotwithgemini.core.constants.Constants
import com.example.chatbotwithgemini.data.local.room.ChatBotDataBase
import com.example.chatbotwithgemini.data.local.room.entities.ChatBot
import com.example.chatbotwithgemini.domain.model.MessageModel
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.launch

class GeminiViewModel(application: Application) : AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application,
        ChatBotDataBase::class.java,
        "chatbot_database"
    ).build()

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
                val chatContext = messageList.joinToString(separator = "\n") { "${it.role}: ${it.message}" }
                val response = chat.sendMessage(chatContext)
                messageList.add(MessageModel(response.text.toString(), Constants.ROLE_MODEL))
                val chatDAO = db.chatDAO()
                chatDAO.insert(item = ChatBot(chat = question, role = Constants.ROLE_USER))
                chatDAO.insert(item = ChatBot(chat = response.text.toString(), role = Constants.ROLE_MODEL))
            }
            catch (e: Exception){
                messageList.add(MessageModel(Constants.ERROR_IN_CONVERSATION+e, Constants.ROLE_MODEL))
            }
        }
    }

    fun loadChat(){
        viewModelScope.launch {
            try {
                val savedChat = db.chatDAO().getChat()
                messageList.clear()
                for (chat in savedChat){
                    messageList.add(MessageModel(message = chat.chat, role = chat.role))
                }
            }
            catch (e: Exception){
                messageList.add(MessageModel(Constants.ERROR_LOADING_CHAT+e, Constants.ROLE_MODEL))
            }
        }
    }

    fun deleteChat(){
        viewModelScope.launch {
            try {
                val chatDAO = db.chatDAO()
                chatDAO.deleteChat()
                messageList.clear()
            }
            catch (e: Exception){
                messageList.add(MessageModel(Constants.ERROR_DELETE_CHAT+e, Constants.ROLE_MODEL))
            }
        }
    }

}