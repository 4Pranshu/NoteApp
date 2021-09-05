package com.example.todoapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var allNotes: LiveData<List<Notes>>
    val repository:NoteRepository

    init {
        val dao = NoteDataBase.getDatabase(application).getNoteDao()
        repository = NoteRepository(dao)
        allNotes = repository.allNotes
    }

    fun deleteNode(note:Notes) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(note)
    }

    fun insertNode(note: Notes) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(note)
    }

}