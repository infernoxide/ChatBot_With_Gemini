package com.example.chatbotwithgemini.presentation.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.chatbotwithgemini.R

@Composable
fun SetTitle(){
    Text(text = stringResource(R.string.home_title), fontWeight = FontWeight.Bold, color = Color.White)
}