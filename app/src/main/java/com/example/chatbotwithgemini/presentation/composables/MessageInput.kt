package com.example.chatbotwithgemini.presentation.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import com.example.chatbotwithgemini.R
import com.example.chatbotwithgemini.presentation.theme.focusColor
import com.example.chatbotwithgemini.presentation.theme.unfocusedColor

@Composable
fun MessageInput(onClick:(String)->Unit){
    var message by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.padding(dimensionResource(R.dimen.size_8dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            value = message,
            onValueChange = { message = it },
            placeholder = { Text(text = stringResource(R.string.write_something)) },
            modifier = Modifier.weight(1f),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = focusColor,
                unfocusedContainerColor = unfocusedColor,
                focusedTextColor = Color.White
            )
        )
        IconButton(
            onClick = {
                if (message.isNotBlank()) {
                    onClick(message.trim())
                    message=""
                }
            }) {
            Icon(imageVector = Icons.AutoMirrored.Default.Send, contentDescription = stringResource(R.string.send))
        }
    }

}