package com.example.ch11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int intYears;
    int intAmount;
    float fRate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText years = (EditText) findViewById(R.id.hint1);
        final EditText amount = (EditText) findViewById(R.id.hint2);
        final EditText rate = (EditText) findViewById(R.id.hint3);
        Button carPaymentButton = (Button) findViewById(R.id.btn);

        carPaymentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intYears = Integer.parseInt(years.getText().toString());
                intAmount= Integer.parseInt(amount.getText().toString());
                fRate = Float.parseFloat(rate.getText().toString());

                final SharedPreferences sharedPref =
                        PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("Key1",intYears);
                editor.putInt("Key2",intAmount);
                editor.putFloat("Key3",fRate);
                editor.commit();

                startActivity(new Intent(MainActivity.this, Payment.class));
            }
        });
     }
}