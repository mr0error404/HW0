package com.example.hw0;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        this.setTitle("rfsghdgfmg");

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Button calculateButton = findViewById(R.id.button2);
        TextView errorTextView = findViewById(R.id.textView2);
        EditText editText = findViewById(R.id.editTextText);
        TextView resultTextView = findViewById(R.id.resultTextView);
        String defaultText = "Enter number of laptops";


        calculateButton.setOnClickListener(v -> {
            String numberOfLaptopsString = editText.getText().toString().trim();
            int selectedId = radioGroup.getCheckedRadioButtonId();

            if (selectedId == -1) {
                errorTextView.setText("Please select a laptop");
                resultTextView.setText("");
                return;
            } else {
                errorTextView.setText("");
            }
            if (numberOfLaptopsString.isEmpty()) {
                errorTextView.setText("Please enter the number of mobile devices");
                resultTextView.setText("");
                return;
            }
//            if (numberOfLaptopsString.equals(defaultText)) {
//                errorTextView.setText("Please enter the number of laptops");
//                return;
//            }
            int numberOfLaptops = Integer.parseInt(numberOfLaptopsString);
            if (numberOfLaptops < 1 || numberOfLaptops > 5) {
                errorTextView.setText("The number of mobile devices must be between 1 and 5");
                resultTextView.setText("");
                return;
            }

            int price = 0;
            RadioButton selectedRadioButton = findViewById(selectedId);

//            switch (selectedRadioButton) {
//                case R.id.radioButton :
//                    price = 3000;
//                    break;
//                case R.id.radioButton2:
//                    price = 2500;
//                    break;
//                case R.id.radioButton3:
//                    price = 2200;
//                    break;
//            }

            if (selectedRadioButton.getId() == R.id.radioButton) {
                price = 3000;
            } else if (selectedRadioButton.getId() == R.id.radioButton2) {
                price = 2500;
            } else if (selectedRadioButton.getId() == R.id.radioButton3) {
                price = 2200;
            }

            int totalCharges = numberOfLaptops * price;
            resultTextView.setText("Thank you. The total is " + totalCharges + ".00 AED.");
        });


    }
}