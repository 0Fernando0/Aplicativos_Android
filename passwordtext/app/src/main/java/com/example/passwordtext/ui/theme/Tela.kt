package com.example.passwordtext.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.passwordtext.R

@Preview(showBackground = true)
@Composable
fun TelaApp(){
    PasswordTextTheme {
        Gui()
    }
}

@Composable
fun Gui(){

    var password by rememberSaveable { mutableStateOf("") }

    var icone by rememberSaveable { mutableStateOf(false) }

    val myIcon = if(icone) R.drawable.visibility_48px else R.drawable.visibility_off_48px

    Column(
        Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text(text = stringResource(R.string.password)) },
            label = { Text(text = stringResource(id = R.string.password)) },
            trailingIcon = {
                IconButton(onClick = { icone = !icone }) {
                    Icon(
                        painter = painterResource(id = myIcon),
                        contentDescription = null,
                        modifier = Modifier
                            .size(20.dp)
                    )
                }
            },
            visualTransformation = if(icone) VisualTransformation.None else PasswordVisualTransformation()

        )
    }

}