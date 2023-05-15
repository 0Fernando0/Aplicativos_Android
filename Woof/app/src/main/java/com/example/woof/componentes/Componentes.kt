package com.example.woof.componentes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.woof.data.Dog

@Composable
fun MyImage(dog: Dog) {
    Image(
        painter = painterResource(id = dog.imagem),
        contentDescription = stringResource(id = dog.nome),
        modifier = Modifier
            .size(68.dp)
            .clip(RoundedCornerShape(50)),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun MyDescrition(
    dog: Dog
) {
    val age = rememberSaveable{(1..15).random()}
    Text(text = stringResource(id = dog.nome))
    Spacer(modifier = Modifier.height(5.dp))
    Text(text = stringResource(id = dog.idade,age))
}