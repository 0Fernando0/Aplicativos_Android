package com.example.singup

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.singup.ui.theme.Shapes

@Preview(showBackground = true)
@Composable
fun GButtonPreview() {
    GButton()
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GButton() {
    var clicked by remember { mutableStateOf(false) }

    Surface(

        onClick = { clicked = !clicked },
        shape = Shapes.medium,
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
        color = MaterialTheme.colors.surface

    ) {
        MyRow(clicked)
    }
}

@Composable
private fun MyRow(parametro: Boolean) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(
                start = 12.dp,
                end = 16.dp,
                top = 12.dp,
                bottom = 12.dp
            )
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
    ) {

        Icon(
            painter = painterResource(id = R.drawable.ic_google_logo),
            contentDescription = null,
            tint = Color.Unspecified
            )

        Spacer(modifier = Modifier.width(8.dp))

        Text(text = if(parametro) "Creating Account..." else "Sing Up with Google")

        if(parametro) {
            Spacer(modifier = Modifier.width(8.dp))
            CircularProgressIndicator(
                modifier = Modifier
                    .height(16.dp)
                    .width(16.dp),
                strokeWidth = 2.dp,
                color = MaterialTheme.colors.primary
            )

        }
    }
}