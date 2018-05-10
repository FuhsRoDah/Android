package com.example.carletonf.lab02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


/***********************************************************
 * MainActivity.java - Create an app that calculates your bill based on the service received
 * Name: Carleton Fuhs**
 * Lab: Lab 2Tip-o-later *
 * Email: cafuhs@coastal.edu**
 * Date: 1/25/2018
 * ***********************************************************/
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //Called when user clicks the button
    public void onClickCalculateBill(View view){
        TextView tip = (TextView) findViewById(R.id.tip);
        Spinner tipSpin = (Spinner) findViewById(R.id.tipSpin);
        EditText bill = (EditText) findViewById(R.id.bill);
        TextView totalBill = (TextView) findViewById(R.id.totalBill);
        double billAmount = Double.parseDouble(bill.getText().toString());
        String tipText = String.valueOf(tipSpin.getSelectedItem());

        double tipPercent=0.0;
        if(tipText.equals("5%(Poor)")){
            tipPercent = 0.05;
        }
        else if(tipText.equals("10%(Good)")){
            tipPercent = 0.1;
        }
        else if(tipText.equals("20%(Excellent)")){
            tipPercent = 0.2;
        }

        double tipCalc = billAmount * tipPercent;
        double totalBillCalc = tipCalc + billAmount;

        StringBuilder tipString = new StringBuilder();
        tipString.append("" +tipCalc);
        tip.setText(tipString);

        StringBuilder totalString = new StringBuilder();
        totalString.append("" +totalBillCalc);
        totalBill.setText(totalString);

    }
}
