package com.example.inspiracao.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.inspiracao.R

data class Afimacao(
    @DrawableRes val imagem: Int,
    @StringRes val titulo: Int
)

val ListaAfirmacao: List<Afimacao> = listOf(
    Afimacao(R.drawable.image1,R.string.affirmation1),
    Afimacao(R.drawable.image2,R.string.affirmation2),
    Afimacao(R.drawable.image3,R.string.affirmation3),
    Afimacao(R.drawable.image4,R.string.affirmation4),
    Afimacao(R.drawable.image5,R.string.affirmation5),
    Afimacao(R.drawable.image6,R.string.affirmation6),
    Afimacao(R.drawable.image7,R.string.affirmation7),
    Afimacao(R.drawable.image8,R.string.affirmation8),
    Afimacao(R.drawable.image9,R.string.affirmation9),
    Afimacao(R.drawable.image10,R.string.affirmation10)
)
