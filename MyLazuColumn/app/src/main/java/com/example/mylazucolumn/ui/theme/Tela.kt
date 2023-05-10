package com.example.mylazucolumn.ui.theme

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mylazucolumn.data.Person
import com.example.mylazucolumn.data.PersonRepository

@Composable
fun MyText(text: String, size: Int, fontWeight: FontWeight){
    Text(
        text = text,
        color = Color.Black,
        fontSize = size.sp,
        fontWeight = fontWeight
    )
}

@Composable
fun CardItem(
    person : Person
) {
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .padding(10.dp)
    ) {
    Row(

        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)

    ){
            MyText(text = "${person.age}",35,FontWeight.Bold)
            MyText(text = person.firstName,30,FontWeight.Normal)
            MyText(text = person.lastName,30,FontWeight.Normal)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Interface() {
    val lista = listOf("A","B","C","D","F")
    MyLazuColumnTheme {
        LazyColumn(
            modifier = Modifier
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ){
            lista.forEach{
                valor -> stickyHeader {
                    Text(
                        text = "Letra $valor",
                        modifier = Modifier
                            .background(Color.LightGray)
                            .fillMaxWidth()
                    )
                }
                items(10){
                    Text(
                        text = "número $it da letra $valor"
                    )
                }
            }
        /*
            items(PersonRepository().getAllData()){
                person -> CardItem(person = person)
            }
        */
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PreviewApp() {
    Interface()
}
