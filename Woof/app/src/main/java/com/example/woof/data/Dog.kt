package com.example.woof.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.woof.R

data class Dog(
    @DrawableRes val imagem: Int,
    @StringRes val nome: Int,
    @StringRes val idade: Int,
    @StringRes val descricao: Int
)

val Dogs: List<Dog> = listOf(
    Dog(R.drawable.koda, R.string.dog_name_1, R.string.years_old , R.string.dog_description_1),
    Dog(R.drawable.lola, R.string.dog_name_2, R.string.years_old , R.string.dog_description_2),
    Dog(R.drawable.frankie, R.string.dog_name_3, R.string.years_old , R.string.dog_description_3),
    Dog(R.drawable.nox, R.string.dog_name_4, R.string.years_old , R.string.dog_description_4),
    Dog(R.drawable.faye, R.string.dog_name_5, R.string.years_old , R.string.dog_description_5),
    Dog(R.drawable.bella, R.string.dog_name_6, R.string.years_old , R.string.dog_description_6),
    Dog(R.drawable.moana, R.string.dog_name_7, R.string.years_old , R.string.dog_description_7),
    Dog(R.drawable.tzeitel, R.string.dog_name_8, R.string.years_old , R.string.dog_description_8),
    Dog(R.drawable.leroy, R.string.dog_name_9, R.string.years_old , R.string.dog_description_9),
)
