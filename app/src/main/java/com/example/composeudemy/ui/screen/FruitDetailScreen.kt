package com.example.composeudemy.ui.screen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeudemy.data.Fruit
import com.example.composeudemy.data.fruitList

@Composable
fun FruitDetailScreen(navController: NavController, fruit: Fruit?) {
    //val fruit = findFruit(id)
    if (fruit != null) {
        Text(text = fruit.name)
    } else {
        navController.popBackStack()
    }
}

@Preview(showBackground = true)
@Composable
private fun FruitDetailScreenPreview() {
    FruitDetailScreen(navController = rememberNavController(), fruitList[2])
}