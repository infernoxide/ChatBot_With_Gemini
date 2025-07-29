package com.example.chatbotwithgemini.presentation.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.chatbotwithgemini.presentation.composables.MessageInput
import com.example.chatbotwithgemini.presentation.composables.SetTitle
import com.example.chatbotwithgemini.presentation.theme.backColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { SetTitle() },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = backColor
                )
            )
        }
    ) { paddingValues ->
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(paddingValues)
                .background(backColor)
        ) {
            MessageInput {

            }
        }
    }
}