package com.example.dizimistafiel.ui.customComponent

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MyTextField(
                input: String,
                onValueChange: (String) -> Unit,
                @StringRes label: Int
                )
{
    OutlinedTextField(
        value = input,
        onValueChange =  onValueChange,
        singleLine = true,
        maxLines = 1,
        label = { Text(text = stringResource(id = label), fontWeight = FontWeight.Bold ) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

@Composable
fun MyCenterColumn(space: Dp = 18.dp,content: @Composable () -> Unit) {
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            verticalArrangement = Arrangement.spacedBy(space),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            content()
        }
    }
}

@Composable
fun MyText(
    @StringRes text: Int,
    args: String?,
    size: TextUnit = 16.sp
) {
    val texto = if (args == null) stringResource(id = text) else stringResource(id = text, args)
    Text(text = texto, fontSize = size)
}
