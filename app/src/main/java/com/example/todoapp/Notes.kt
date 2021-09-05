package com.example.todoapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "to_do_table")
class Notes(@ColumnInfo(name = "text") val text: String) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}