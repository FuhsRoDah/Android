package com.example.carletonf.lab05;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

/*
 *Carleton Fuhs
 * Assignment 4
 * Make Fragment 1 show movie data and Fragment 2 show an image with a seekbar
 * 04/04/18
 * CSCI 343
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container,new Fragment_One());
        fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int item_id = item.getItemId();
        switch(item_id){
            case R.id.frag_one:
                Toast.makeText(getApplicationContext(),
                        "Movie Details clicked",Toast.LENGTH_LONG).show();
                swapFragment(item_id);
                return true;
            case R.id.frag_two:
                Toast.makeText(getApplicationContext(),
                        " clicked",Toast.LENGTH_LONG).show();
                swapFragment(item_id);
                return true;
        }
        return false;
    }

    private void swapFragment(int item_id){
        Fragment fragment = null;

        if(item_id == R.id.frag_one){
            fragment = new Fragment_One();
        }
        else if(item_id == R.id.frag_two){
            fragment = new Fragment_Two();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed(){
        if(getFragmentManager().getBackStackEntryCount()>0){
            getFragmentManager().popBackStack();
        }
        else{
            super.onBackPressed();
        }
    }

}
