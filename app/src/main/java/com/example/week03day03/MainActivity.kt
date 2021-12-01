package com.example.week03day03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    private var listview:ListView?= null
    private var editTextFilter:EditText?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        connectViews()
        prepareListView()
    }

    private fun connectViews(){
        listview = findViewById(R.id.list)
        editTextFilter = findViewById(R.id.etFilter)
    }

    private fun prepareListView(){
        val array:ArrayList<String> = arrayListOf()
        array.add("Orange")
        array.add("Oraaaa")
        array.add("Apple")
        array.add("Grape")
        array.add("Cherry")
        array.add("Cherry")
        array.add("Cherry")
        array.add("Cherry")
        array.add("Cherry")
        array.add("Cherry")
        array.add("Cherry")
        array.add("Cherry")


        /*
        1) this (Context)
        2) Layout (To display data)
        3) Data Source (array)
         */
        val arrayAdapter:ArrayAdapter<String> = ArrayAdapter(this
            ,R.layout.support_simple_spinner_dropdown_item,array)

        //Connect list view with data
        listview?.adapter = arrayAdapter


        listview?.setOnItemClickListener { parent, view, position, id ->

            Log.i("Item Removed","This item is removed ${array.get(position)}")
            array.removeAt(position)
            //We call this function to update listView
            arrayAdapter.notifyDataSetChanged()
        }

        editTextFilter?.addTextChangedListener { text ->
            arrayAdapter.filter.filter(text)
        }

    }
}