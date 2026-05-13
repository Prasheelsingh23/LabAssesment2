package com.example.labassesment2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText txtName, txtPhone, txtEmail;
    Spinner spinnerFood;
    Button btnOrder;

    String[] foodItems = {
              "Chicken Palau",
            "Lamb Palau",
            "Pizza",
            "Chow Mein"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtPhone = findViewById(R.id.txtPhone);
        txtEmail = findViewById(R.id.txtEmail);
        spinnerFood = findViewById(R.id.spinnerFood);
        btnOrder = findViewById(R.id.btnOrder);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                foodItems
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFood.setAdapter(adapter);

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = txtName.getText().toString();
                String phone = txtPhone.getText().toString();
                String email = txtEmail.getText().toString();
                String food = spinnerFood.getSelectedItem().toString();


                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    Toast.makeText(MainActivity.this,
                            "Invalid Email Address",
                            Toast.LENGTH_SHORT).show();
                }
                else {

                    Intent intent = new Intent(MainActivity.this,
                            SecondActivity.class);

                    intent.putExtra("name", name);
                    intent.putExtra("phone", phone);
                    intent.putExtra("email", email);
                    intent.putExtra("food", food);

                    startActivity(intent);
                }
            }
        });
    }
}
