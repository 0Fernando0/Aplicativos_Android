package com.fernando.todolist.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Tarefa::class],
    version = 1
)
abstract class BancoDeDados: RoomDatabase() {

    abstract val dao: TodoDao
    
}