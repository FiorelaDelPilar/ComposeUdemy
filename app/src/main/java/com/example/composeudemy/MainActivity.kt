package com.example.composeudemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewStory()
        }
    }

}

@Composable
private fun NewStory() {
    val image = painterResource(id = R.mipmap.header2)

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        val imageModifier = Modifier
            .requiredHeight(100.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(10.dp))

        Image(
            painter = image,
            contentDescription = "Header",
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.padding(top = 10.dp))
        Text(text = "Titulo de la noticia", style = MaterialTheme.typography.h6)
        Text(text = "Descripción de la noticia", style = MaterialTheme.typography.body2)
        Text(text = "Pie de página de la noticia", style = MaterialTheme.typography.body2)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewStory() {
    NewStory()
}

