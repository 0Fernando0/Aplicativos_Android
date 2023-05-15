package com.fernando.desembaralhar.view

import android.app.Activity
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
internal fun FinalScoreDialog(
    onPlayAgain: () -> Unit,
    modifier: Modifier = Modifier
) {
    val activity = (LocalContext.current as Activity)
    AlertDialog(
        onDismissRequest = {  },
    title = { Text(text = "Parabens") },
    text = { Text(text = "você concluiu o game") },
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = { activity.finish() }){
                Text(text = "Sair")
            }
        },
        confirmButton = {
            TextButton(onClick = { onPlayAgain() }){
                Text(text = "Continuar")
            }
        }
    )

}