package com.example.homemortgageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        TextView monthlyPayment = (TextView) findViewById(R.id.txtMonthlyPayment);
        ImageView image = (ImageView) findViewById(R.id.imgYears);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        int intYears = sharedPref.getInt("key1", 0);
        int intLoan = sharedPref.getInt("key2", 0);
        float floatInterest = sharedPref.getFloat("key3", 0);
        float flMonthlyPayment;

        flMonthlyPayment = (intLoan * (1 + (floatInterest * intYears))) / (12 * intYears);
        DecimalFormat currency = new DecimalFormat("$###,###.00");
        monthlyPayment.setText("Monthly Mortgage Payment: " + currency.format(flMonthlyPayment));
        if (intYears == 10) {
            image.setImageResource(R.drawable.ten);
        } else if (intYears == 20) {
            image.setImageResource(R.drawable.twenty);
        } else if (intYears == 30) {
            image.setImageResource(R.drawable.thirty);
        } else {
            monthlyPayment.setText("Please enter 10, 20, or 30 years");
        }
    }
}
