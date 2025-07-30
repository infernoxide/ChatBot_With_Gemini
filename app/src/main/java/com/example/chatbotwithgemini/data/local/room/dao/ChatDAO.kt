package com.example.chatbotwithgemini.data.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chatbotwithgemini.data.local.room.entities.ChatBot

@Dao
interface ChatDAO {
    @Query("SELECT * FROM chatbot ORDER BY id ASC")
    suspend fun getChat(): List<ChatBot>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item:ChatBot)

    @Query("DELETE FROM chatbot")
    suspend fun deleteChat()
}