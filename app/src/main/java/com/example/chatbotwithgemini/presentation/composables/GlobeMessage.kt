package com.example.chatbotwithgemini.presentation.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import com.example.chatbotwithgemini.R
import com.example.chatbotwithgemini.core.constants.Constants
import com.example.chatbotwithgemini.domain.model.MessageModel

@Composable
fun GlobeMessage(messageModel: MessageModel) {
    val roleModel = messageModel.role == Constants.ROLE_MODEL

    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .align(if (roleModel) Alignment.BottomStart else Alignment.BottomEnd)
                    .clip(RoundedCornerShape(48f))
                    .background(if (roleModel) Color.Black else Color.DarkGray)
                    .padding(dimensionResource(R.dimen.size_10dp))
            ){
                Text(text = messageModel.message, fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}