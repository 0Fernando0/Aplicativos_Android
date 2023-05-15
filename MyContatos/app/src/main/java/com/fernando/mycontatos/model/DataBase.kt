package com.fernando.mycontatos.model

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DataBase(
    context: Context
) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "database.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "usuarios"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NOME = "nome"
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            "CREATE TABLE IF NOT EXISTS $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT, $COLUMN_NOME TEXT)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}

    fun inserir(nome: String): Long {
        val db = writableDatabase
        val contentValues = ContentValues().apply {
            put(COLUMN_NOME, nome)
        }
        val id = db.insert(TABLE_NAME, null, contentValues)
        db.close()
        return id
    }

    @SuppressLint("Range")
    fun visualizarDados(): List<String> {
        val db = readableDatabase
        val dados = mutableListOf<String>()

        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query, null)

        if (cursor.moveToFirst()) {
            do {
                val nome = cursor.getString(cursor.getColumnIndex(COLUMN_NOME))
                dados.add(nome)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return dados
    }
}