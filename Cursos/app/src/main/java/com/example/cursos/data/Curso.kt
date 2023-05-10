package com.example.cursos.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.cursos.R

data class Curso(
    @DrawableRes val imagem: Int,
    @StringRes val titulo: Int
)

val ListaEsquerda: List<Curso> = listOf(
    Curso(R.drawable.architecture,R.string.architecture),
    Curso(R.drawable.business,R.string.business),
    Curso(R.drawable.crafts,R.string.crafts),
    Curso(R.drawable.design,R.string.design),
    Curso(R.drawable.culinary,R.string.culinary),
    Curso(R.drawable.drawing,R.string.drawing),
    Curso(R.drawable.fashion,R.string.fashion)
)

val ListaDireita: List<Curso> = listOf(
    Curso(R.drawable.film,R.string.film),
    Curso(R.drawable.gaming,R.string.gaming),
    Curso(R.drawable.lifestyle,R.string.lifestyle),
    Curso(R.drawable.tech,R.string.tech),
    Curso(R.drawable.music,R.string.music),
    Curso(R.drawable.painting,R.string.painting),
    Curso(R.drawable.photography,R.string.photography)
)