package com.example.ch11;

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

        TextView monthlyPayment = (TextView) findViewById(R.id.monthlyPayment);
        ImageView imageView = (ImageView) findViewById(R.id.imageResult);

        SharedPreferences sharedPref =
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext());

        int intYears = sharedPref.getInt("Key1",0);
        int intAmount = sharedPref.getInt("Key2",0);
        float fRate = sharedPref.getFloat("Key3",0);

        float result = (intAmount * (1+ (fRate* intYears)))/(12*intYears);
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        monthlyPayment.setText("Monthly Payment "+ currency.format(result));

        if(intYears == 3){
            imageView.setImageResource(R.drawable.three);
        } else if (intYears == 4) {
            imageView.setImageResource(R.drawable.four);
        } else if (intYears == 5) {
            imageView.setImageResource(R.drawable.five);
        }else{
            monthlyPayment.setText("Please Enter correct years such as 3 , 4 , 5 years");
        }
    }
}