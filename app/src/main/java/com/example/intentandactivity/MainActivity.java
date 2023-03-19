package com.example.intentandactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView editNameText, editAddressText, editAgeText;
    RadioGroup genderRadioGroup;
    Button submitBtn;

    String selectedGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNameText = findViewById(R.id.editNameText);
        editAddressText = findViewById(R.id.editAddressTv);
        editAgeText = findViewById(R.id.editAgeText);

        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        genderRadioGroup.setOnCheckedChangeListener((genderRadioGroup, selectedId) -> {
            switch (selectedId) {
                case R.id.maleRadioButton:
                    selectedGender = "Male";
                    break;
                case R.id.femaleRadioButton:
                    selectedGender = "Female";
                    break;
            }
        });

        submitBtn = findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(view -> {
            int selectedId = genderRadioGroup.getCheckedRadioButtonId();

            if(editNameText.getText()==""){
                editNameText.setError("Enter name");
            }else if(editAddressText.getText() == ""){
                editAddressText.setError("Enter Address");
            }else if(editAgeText.getText()==""){
                editAgeText.setError("Enter Age");
            }else if(selectedId<0){
                RadioButton femaleRB = findViewById(R.id.femaleRadioButton);
                femaleRB.setError("Select a gender");
            }else{
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                intent.putExtra("name",editNameText.getText().toString());
                intent.putExtra("address",editAddressText.getText().toString());
                intent.putExtra("gender", selectedGender);
                intent.putExtra("age", editAgeText.getText().toString());

                startActivity(intent);
            }
        });
    }
}