package com.example.tutorial

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorial.ui.theme.Shapes
import com.example.tutorial.ui.theme.TutorialTheme

// cartão expansivel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Cartao() {
    var expansivel by remember {
        mutableStateOf(false)
    }

    val rotationState by animateFloatAsState(
        targetValue = if (expansivel) 180f else 0f
    )

    Card(
        modifier = Modifier
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 30,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = Shapes.medium,
        onClick = {
            expansivel = !expansivel
        }
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Titulo",
                        fontSize = MaterialTheme.typography.h6.fontSize,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                        )
                    IconButton(
                        onClick = { expansivel = !expansivel },
                        modifier = Modifier
                            .alpha(ContentAlpha.medium)
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = null,
                            Modifier
                                .rotate(rotationState)
                        )
                    }
            }
            if (expansivel){
                Text(
                    text = "Lorem LoremLorem LoremLorem LoremLorem LoremLorem LoremLorem Lorem" +
                            "Lorem LoremLorem LoremLorem LoremLorem LoremLorem LoremLorem Lorem" +
                            "Lorem LoremLorem LoremLorem LoremLorem LoremLorem LoremLorem Lorem" +
                            "Lorem LoremLorem LoremLorem LoremLorem LoremLorem LoremLorem Lorem",
                    fontSize = 16.sp,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Janela(){
    TutorialTheme {
        Column(Modifier.fillMaxSize()) {
            Cartao()
        }
    }
}