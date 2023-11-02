package com.example.composeudemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Saludar("Tara")
        }
    }

}

@Composable
fun Saludar(nombre: String) {
    Text(text = "Hola $nombre")
}

@Preview
@Composable
fun PreviewText() {
    Saludar("Tara")
}
