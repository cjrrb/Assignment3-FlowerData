package com.example.assignment3.ui.flowerdetails

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.assignment3.domain.Flower


@Composable
fun DetailsScreenContent(flower: Flower, modifier: Modifier = Modifier) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth()
    ){
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = flower.label,
                fontSize = 32.sp
            )
        }

        AsyncImage(
            model = flower.picture,
            contentDescription = flower.label,
            modifier = Modifier.clip(RoundedCornerShape(8.dp))
        )
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = flower.description,
                fontSize = 16.sp
            )
        }
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)

        ) {
            Text(
                text = flower.price.toString(),
                fontSize = 24.sp
            )
        }
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val context = LocalContext.current

            ClickableText(
                text = AnnotatedString("Open ${flower.label} Wiki Page"),
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(flower.wiki))
                    context.startActivity(intent)
                },
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue,
                    textDecoration = TextDecoration.Underline
                )
            )
        }
    }
}