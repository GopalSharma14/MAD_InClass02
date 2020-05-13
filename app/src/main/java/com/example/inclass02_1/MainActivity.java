package com.example.inclass02_1;

// Assignment InClass02
//MainActivity.Java
//Gopal Sharma and Priyaank Chhadwa
//Group 27

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_weight;
    private EditText et_height_feet;
    private EditText et_height_inches;

    private TextView tv_result;
    private TextView tv_verdict;

    private Button button_calculate;

    double weight = 0.0;
    int feet = 0;
    int inches = 0;
    double bmi = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et_weight = findViewById(R.id.et_weight);
        et_height_feet = findViewById(R.id.et_height_feet);
        et_height_inches = findViewById(R.id.et_height_inches);

        tv_result = findViewById(R.id.tv_result);
        tv_verdict = findViewById(R.id.tv_verdict);

        button_calculate = findViewById(R.id.button_calculate);

        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight_text = et_weight.getText().toString();
                String feet_text = et_height_feet.getText().toString();
                String inches_text = et_height_inches.getText().toString();

                if (weight_text.equals("")) {
                    et_weight.setError("Cant be empty");
                } else if (feet_text.equals("")) {
                    et_height_feet.setError("Cant be empty");
                } else if (inches_text.equals("")) {
                    et_height_inches.setError("Cant be empty");
                } else {
                    weight = Double.parseDouble(weight_text);
                    feet = Integer.parseInt(feet_text);
                    feet = feet * 12;
                    inches = Integer.parseInt(inches_text);
                    inches = feet + inches;

                    bmi = ((weight) / (inches * inches) * 703);
                    bmi = Math.round(bmi * 10) / 10.0d;

                    tv_result.setText(String.valueOf(bmi));

                    if (bmi <= 18.5) {
                        tv_verdict.setText("Underweight");
                    } else if (bmi > 18.5 && bmi <= 24.9) {
                        tv_verdict.setText("Normal Weight");
                    } else if (bmi >= 25 && bmi <= 29.9) {
                        tv_verdict.setText("Overweight");
                    } else if (bmi >= 30) {
                        tv_verdict.setText("Obese");
                    }
                }

            }

        });
    }
}