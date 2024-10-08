package com.example.textcustom

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import com.example.textcustom.ui.theme.TextCustomTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextCustomTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TextCustomTheme {
        SuperScriptText("Hello","World!")
    }
}

@Composable
fun SuperScriptText(
    normalText: String,
    superText: String
) {
    Text(
        buildAnnotatedString {

            withStyle(
                style = SpanStyle(
                    fontSize = MaterialTheme.typography.subtitle1.fontSize
                )
            ){
                append(normalText)
            }

            withStyle(
                style = SpanStyle(
                    fontSize = MaterialTheme.typography.overline.fontSize,
                    fontWeight = FontWeight.Normal,
                    baselineShift = BaselineShift.Subscript
                )
            ){
                append(superText)
            }
        }
    )
}

@Composable
fun Qualquer(
    texto: TextUnit = MaterialTheme.typography.body2.fontSize
) {

}

