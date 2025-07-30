package com.example.chatbotwithgemini.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.chatbotwithgemini.data.local.room.dao.ChatDAO
import com.example.chatbotwithgemini.data.local.room.entities.ChatBot

@Database(entities = [ChatBot::class], version = 1, exportSchema = false)
abstract class ChatBotDataBase: RoomDatabase() {
    abstract fun chatDAO(): ChatDAO
}