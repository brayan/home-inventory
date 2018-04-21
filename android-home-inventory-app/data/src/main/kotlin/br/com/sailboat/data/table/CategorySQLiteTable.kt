package br.com.sailboat.homeinventory.data.table

class CategorySQLiteTable : SQLiteTable {

    override val createTableStatement = StringBuilder()
        .append(" CREATE TABLE CategoryData ( ")
        .append(" id INTEGER PRIMARY KEY AUTOINCREMENT, ")
        .append(" name TEXT NOT NULL, ")
        .append(" created DATETIME DEFAULT (datetime('now', 'localtime')), ")
        .append(" lastModified DATETIME DEFAULT (datetime('now', 'localtime')) ")
        .append(" ); ")
        .toString()

}