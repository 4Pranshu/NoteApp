package com.example.todoapp

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface NoteDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Notes)

    @Delete
    suspend fun delete(note: Notes)


    @Query("Select * from to_do_table order by id asc")
    fun getAllNotes(): LiveData<List<Notes>>


}