package com.example.labassesment2;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtResult = findViewById(R.id.txtResult);

        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");
        String email = getIntent().getStringExtra("email");
        String food = getIntent().getStringExtra("food");

        String result =
                "Order Placed Successfully\n\n" +
                        "Customer Name: " + name + "\n" +
                        "Phone Number: " + phone + "\n" +
                        "Email Address: " + email + "\n" +
                        "Food Item Ordered: " + food;

        txtResult.setText(result);
    }
}