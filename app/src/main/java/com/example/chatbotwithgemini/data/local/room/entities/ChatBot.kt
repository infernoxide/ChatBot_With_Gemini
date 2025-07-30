package com.example.chatbotwithgemini.data.local.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ChatBot")
data class ChatBot(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    val chat : String,
    val role : String
)
