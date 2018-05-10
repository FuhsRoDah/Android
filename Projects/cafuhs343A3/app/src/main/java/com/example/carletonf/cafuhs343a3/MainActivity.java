package com.example.carletonf.cafuhs343a3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import java.util.*;
import java.io.*;
import android.widget.ArrayAdapter;
import android.os.Parcelable;



/***
 * Carleton Fuhs
 * Assignment 3
 * Create a to-do list app that saves the user input to a listview with the ability to add and remove
 * Unfortunately I could not get the state of the listview to save
 * 03/18/18
 ***/

public class MainActivity extends AppCompatActivity {

    EditText userinput;
    ListView list;
    ArrayList<String> listItems;
    ArrayAdapter adapter;
    String input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userinput = (EditText)findViewById(R.id.userinput);
        list = (ListView)findViewById(R.id.list);
        listItems = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,listItems);

        /*
         * Below is the code used to attempt to save the instance state
         * it didn't work
         */
        Parcelable state = list.onSaveInstanceState();
        list.setAdapter(adapter);
        list.onRestoreInstanceState(state);

        if(savedInstanceState!=null){
            listItems = savedInstanceState.getStringArrayList("listItems");
            input = savedInstanceState.getString("input");
        }

        /*
         * Below is the code to set up the on long click listener
         * Hold the click on an item in the list to remove it
         */
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                listItems.remove(i);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }
    /*
     * When the add button is clicked, the text from the editText gets added to the listview
     */
    public void onClickAdd(View view){
        input = String.valueOf(userinput.getText());
        listItems.add(input);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putStringArrayList("listItems",listItems);
        savedInstanceState.putString("input",input);
        savedInstanceState.putParcelable("listinstance", list.onSaveInstanceState());
    }
/*
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        listItems = savedInstanceState.getStringArrayList("listItems");
        input = savedInstanceState.getString("input");
        listItems.add(input);
        adapter.notifyDataSetChanged();
    }

*/

}
