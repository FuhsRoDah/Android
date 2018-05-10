package com.example.carletonf.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.EditText;

/***********************************************************
 * MainActivity.java - Create an app that calculates the price of a dress based on options picked
 * Name: Carleton Fuhs**
 * Lab: Homework 1 Dress App *
 * Email: cafuhs@coastal.edu**
 * Date: 02/02/2018
 * ***********************************************************/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickEnter(View view){
        EditText base = (EditText) findViewById(R.id.baseprice);
        double baseAmount = Double.parseDouble(base.getText().toString());
        Spinner size = (Spinner) findViewById(R.id.size);
        String selectedSize = String.valueOf(size.getSelectedItem());
        Spinner material = (Spinner) findViewById(R.id.material);
        String selectedMat = String.valueOf(material.getSelectedItem());
        Spinner pocket = (Spinner) findViewById(R.id.pocket);
        String selectedPocket = String.valueOf(pocket.getSelectedItem());
        TextView totalprice = (TextView) findViewById(R.id.totalprice);

        double sizeprice=0.0;
        double matprice=0.0;
        double pocketprice=0.0;
        double total=0.0;
        total = total + baseAmount;

        if(selectedSize.equals("Large($100)")||selectedSize.equals("Extra Large($100)")){
            sizeprice = sizeprice + 100.0;
            total = total + sizeprice;
        }
        else{
            sizeprice=0.0;
        }

        if(selectedMat.equals("Cotton($50)")){
            matprice = matprice + 50.0;
            total = total + matprice;
        }
        else if(selectedMat.equals("Flannel($25)")){
            matprice = matprice + 25.0;
            total = total + matprice;
        }
        else if(selectedMat.equals("Linen($75)")){
            matprice = matprice + 75.0;
            total = total + matprice;
        }
        else if(selectedMat.equals("Silk($150)")){
            matprice = matprice + 150.0;
            total = total + matprice;
        }
        else{
            matprice = 0.0;
        }

        if(selectedPocket.equals("1($30)")){
            pocketprice = pocketprice + 30.0;
            total = total + pocketprice;
        }
        else if(selectedPocket.equals("2($60)")){
            pocketprice = pocketprice + 60.0;
            total = total + pocketprice;
        }
        else if(selectedPocket.equals("3($90)")){
            pocketprice = pocketprice + 90.0;
            total = total + pocketprice;
        }
        else if(selectedPocket.equals("4($120)")){
            pocketprice = pocketprice + 120.0;
            total = total + pocketprice;
        }

        StringBuilder totalString = new StringBuilder();
        totalString.append("Total: " +total);
        totalprice.setText(totalString);


    }
}
