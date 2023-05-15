package com.fernando.todolist.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDao {

    // FUNÇÃO PARA ADICIONAR DADOS AO SQL
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserir(tarefa: Tarefa)

    // FUNÇÃO PARA APAGAR DADOS DO SQL
    @Delete
    suspend fun apagar(tarefa: Tarefa)

    // FUNÇÃO PARA PEGAR UMA DADO POR ID DO SQL
    @Query("SELECT * FROM tarefa WHERE id = :id")
    suspend fun pegarId(id: Int): Tarefa?

    @Query("SELECT * FROM tarefa")
    fun pegar(): Flow<List<Tarefa>>
}