package com.example.composeudemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

data class Recipe(
    @DrawableRes
    val imageResource: Int,
    val title: String,
    val ingredientes: List<String>
)

val recipeList = listOf(
    Recipe(R.mipmap.header2, "Arrozmate", listOf("Arroz", "Tomate", "Crema")),
    Recipe(R.mipmap.header2, "Calabaza con queso", listOf("Queso", "Azúcar", "Calabaza")),
    Recipe(R.mipmap.header2, "Torta", listOf("Harina", "Leche", "Mantequilla")),
    Recipe(R.mipmap.header2, "Puré de papa", listOf("Leche", "Papa", "Mantequilla")),
    Recipe(R.mipmap.header2, "Pizza", listOf("Harina", "Polvo de hornear", "Mozzarella"))
)

@Composable
private fun RecipeCard(recipe: Recipe){
    val image = painterResource(id = R.mipmap.header2)
    Card(shape= RoundedCornerShape(8.dp), elevation = 8.dp, modifier = Modifier.padding(8.dp)){
        Column(modifier = Modifier.padding(16.dp)) {
            val imageModifer = Modifier
                .requiredHeight(120.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
            Image(painter = image, modifier = imageModifer, contentScale = ContentScale.Crop, contentDescription = "Foto receta")
            Spacer(modifier =  Modifier.padding(top = 10.dp))
            Text(text = recipe.title, style = MaterialTheme.typography.h6)
            for(ingredient in recipe.ingredientes){
                Text(text = "* $ingredient", style = MaterialTheme.typography.body2 )
            }
        }
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeColumnList(recipeList = recipeList)
        }
    }

}

@Composable
private fun RecipeColumnList(recipeList: List<Recipe>){
    LazyRow{
        items(recipeList){recipe ->
            RecipeCard(recipe = recipe)
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
    RecipeCard(recipe = recipeList[0])
}

