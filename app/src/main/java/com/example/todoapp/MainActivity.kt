package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemClicked {

    lateinit var viewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rc_view.layoutManager = LinearLayoutManager(this)
        val MyAdapter = NotesAdapter(this,this)
        rc_view.adapter = MyAdapter
        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)

        viewModel.allNotes.observe(this, Observer {
            MyAdapter.updateList(it)
        })




    }

    override fun onItemClicked(notes: Notes) {
        viewModel.deleteNode(notes)
    }

    fun submitData(view: View) {
        val txt = Task.text.toString()
        if (txt.isNotEmpty()){
            viewModel.insertNode(Notes(txt))
        }
    }
}