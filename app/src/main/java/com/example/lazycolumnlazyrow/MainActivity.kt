package com.example.lazycolumnlazyrow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column() {
                VegetablesRow()
                FruitsColumn()
            }
        }
    }
}

@Composable
fun VegetablesRow() {
    val vegetablesList = mutableListOf(
        ProductModel(R.drawable.look, "Лук", "120р"),
        ProductModel(R.drawable.ogurec, "Огурец", "180р"),
        ProductModel(R.drawable.perec, "Перец", "190р"),
        ProductModel(R.drawable.potato, "Картошка", "30р"),
        ProductModel(R.drawable.tomato, "Томат", "165р"),
    )
    Column {
        Text(
            text = "Овощи",
            fontSize = 32.sp,
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp, top = 16.dp)
                .fillMaxWidth()
                .border(width = 2.dp, Color.Black),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(4.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                .border(width = 2.dp, Color.Black)

        ) {
            items(vegetablesList) { vegetable ->
                VegetableRow(model = vegetable)
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun VegetableRow(model: ProductModel) {
    var isClick by remember {
        mutableStateOf(false)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .clickable {
                isClick = !isClick
            }
            .background(if (isClick) Color.Red else Color.Cyan)
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = model.cost,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun FruitsColumn() {
    val fruitsList = mutableListOf(
        ProductModel(R.drawable.apple, "Яблоко", "120р"),
        ProductModel(R.drawable.banana, "Банан", "180р"),
        ProductModel(R.drawable.grusha, "Груша", "90р"),
        ProductModel(R.drawable.orange, "Апельсин", "135р"),
        ProductModel(R.drawable.qivi, "Киви", "165р"),
    )

    Column {
        Text(
            text = "Фрукты",
            fontSize = 32.sp,
            modifier = Modifier
                .padding(start = 8.dp, end = 8.dp)
                .fillMaxWidth()
                .border(width = 1.dp, Color.Black),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.padding(4.dp))

        LazyColumn(
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 16.dp)
                .border(width = 2.dp, Color.Black)
        ) {

            items(fruitsList) { fruit ->
                FruitRow(model = fruit)
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Composable
fun FruitRow(model: ProductModel) {
    var isClick by remember {
        mutableStateOf(false)
    }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .clickable {
                isClick = !isClick
            }
            .background(if (isClick) Color.Red else Color.Cyan)
    ) {
        Image(
            painter = painterResource(id = model.image),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .padding(5.dp)
        )
        Text(
            text = model.name,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = model.cost,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

data class ProductModel(val image: Int, val name: String, val cost: String)