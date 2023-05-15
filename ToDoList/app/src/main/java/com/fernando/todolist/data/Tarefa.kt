package com.fernando.todolist.data

import androidx.room.Entity
import androidx.room.PrimaryKey


// criando uma entidade SQL
@Entity
data class Tarefa(
    val titulo: String,
    val descricao: String?,
    val concluido: Boolean,
    @PrimaryKey val id: Int? = null
)
