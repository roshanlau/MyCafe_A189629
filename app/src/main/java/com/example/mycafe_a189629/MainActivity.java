package com.example.mycafe_a189629;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tvTitle;
    EditText etName;
    TextView tvDrink;
    TextView tvQuantity;
    Button btnAdd;
    Button btnMinus;
    Button btnCheckout;

    int quantity;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitle = findViewById(R.id.tv_title);
        etName = findViewById(R.id.et_name);
        tvDrink = findViewById(R.id.tv_drink);
        tvQuantity = findViewById(R.id.tv_quantity);
        btnAdd = findViewById(R.id.btn_add);
        btnMinus = findViewById(R.id.btn_minus);
        btnCheckout = findViewById(R.id.btn_checkout);

        quantity = 0;
        name = "";

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity++;
                tvQuantity.setText(""+quantity);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(quantity <= 0){
                    Toast.makeText(MainActivity.this, "Cannot be less than 0.", Toast.LENGTH_SHORT).show();
                }else{
                    quantity--;
                    tvQuantity.setText(""+quantity);
                }
            }
        });

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = etName.getText().toString();
                if(name == "" && quantity <= 0){
                    Toast.makeText(MainActivity.this, "Please Enter Appropriate Name or Amount of Drink.", Toast.LENGTH_SHORT).show();
                }else if(name == ""){
                    Toast.makeText(MainActivity.this, "Please Enter Appropriate Name.", Toast.LENGTH_SHORT).show();
                }else if(quantity <= 0){
                    Toast.makeText(MainActivity.this, "Please Enter Appropriate Amount of Drink.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Thank You " + name + " for order: " + quantity + " Latte.", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, OrderDetailActivity.class);
                    intent.putExtra("quantity", quantity);
                    intent.putExtra("name", name);

                    tvQuantity.setText(""+quantity);
                    quantity = 0;
                    name = "";
                    etName.setText("");

                    startActivity(intent);

                }

            }
        });

    }
}