package com.example.intentandactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView resultNameText, resultAddressText, resultAgeText, resultGenderText;
    String name,address,age,gender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultNameText = findViewById(R.id.resultNameTv);
        resultAddressText = findViewById(R.id.resultAddressTv);
        resultAgeText = findViewById(R.id.resultAgeTv);
        resultGenderText = findViewById(R.id.resultGenderTv);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("name");
            address = extras.getString("address");
            age = extras.getString("age");
            gender = extras.getString("gender");
        }

        resultNameText.setText(name);
        resultAddressText.setText(address);
        resultAgeText.setText(age);
        resultGenderText.setText(gender);

        Button closeBtn = findViewById(R.id.resultCloseBtn);
        closeBtn.setOnClickListener(view -> {
            System.exit(0);
        });
    }
}