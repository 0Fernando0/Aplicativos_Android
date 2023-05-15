package com.example.woof.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.woof.componentes.MyDescrition
import com.example.woof.componentes.MyImage
import com.example.woof.data.Dog
import com.example.woof.data.Dogs
import com.example.woof.ui.theme.WoofTheme

@Preview(showBackground = true)
@Composable
fun DogCardPreview() {
    WoofTheme {

        LazyColumn {
            items(Dogs) { item ->
                DogCard(dog = item)
            }
        }

    }
}

@Composable
fun DogCard(
    dog: Dog
) {
    var status by remember{
        mutableStateOf(false)
    }
    val icone = if (status) Icons.Default.ExpandLess else Icons.Default.ExpandMore
    Card(
        modifier = Modifier
            .padding(8.dp),
        elevation = 4.dp
    ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                MyImage(dog = dog)
                Spacer(modifier = Modifier.width(10.dp))
                Column(
                    verticalArrangement = Arrangement.Center
                ) {
                    MyDescrition(dog = dog)
                }
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { status = !status }) {
                    Icon(
                        imageVector = icone,
                        contentDescription = null)
                }

            }

    }

}

