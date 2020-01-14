package com.prinster.notes.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.database.sqlite.SQLiteQueryBuilder
import android.widget.Toast

class DbManager(context: Context) {
    val dbName = "MyNotes"
    val dbTable = "Notes"

    private val colID = "ID"
    private val colName = "Title"
    private val colDesc = "Content"
    private val dbVersion = 1

    val sqlCreateTable = "CREATE TABLE IF NOT EXISTS $dbTable ($colID INTEGER PRIMARY KEY, $colName TEXT, $colDesc TEXT);"

    private var sqlDB: SQLiteDatabase? = null

    fun insert(values: ContentValues):Long{
        return sqlDB!!.insert(dbName, "", values)
    }

    fun query(projection:Array<String>, selection:String, selectionArgs:Array<String>, sortOrder: String): Cursor {
        val queryBuilder = SQLiteQueryBuilder()
        queryBuilder.tables = dbName
        return queryBuilder.query(sqlDB, projection, selection, selectionArgs, null, null, sortOrder)
    }

    fun delete(selection: String, selectionArgs: Array<String>): Int {
        return sqlDB!!.delete(dbName, selection, selectionArgs)
    }

    fun update(values: ContentValues, selection: String, selectionArgs: Array<String>):Int {
        return sqlDB!!.update(dbName, values, selection, selectionArgs)
    }

    inner class DatabaseHelperNotes(context: Context) : SQLiteOpenHelper(context, dbName, null, dbVersion) {
        private var context:Context? = context

        override fun onCreate(p0: SQLiteDatabase?) {
            p0!!.execSQL(sqlCreateTable)
            Toast.makeText(this.context, "Database Created!", Toast.LENGTH_SHORT).show()
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            p0!!.execSQL("DROP TABLE IF EXISTS $dbTable")
        }

    }

    init {
        val db = DatabaseHelperNotes(context)
        sqlDB = db.writableDatabase
    }
}