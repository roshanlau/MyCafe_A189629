package com.example.mycafe_a189629;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderDetailActivity extends AppCompatActivity implements OnClickListener{
    ImageButton btnCall, btnWeb, btnEmail;
    TextView tvName, tvQuantity;
    String name;
    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        btnCall = findViewById(R.id.btn_Call_OrderActivity);
        btnEmail = findViewById(R.id.btn_Email_OrderActivity);
        btnWeb = findViewById(R.id.btn_Web_OrderActivity);

        tvName = findViewById(R.id.tv_Name_OrderActivity);
        tvQuantity = findViewById(R.id.tv_Quantity_OrderActivity);

        Intent intent = getIntent();
        quantity = intent.getIntExtra("quantity", 0);
        name = intent.getStringExtra("name");

        tvName.setText(name);
        tvQuantity.setText(""+quantity);

        btnCall.setOnClickListener(this);
        btnWeb.setOnClickListener(this);
        btnEmail.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_Call_OrderActivity:
                Toast.makeText(OrderDetailActivity.this, "Btn Call", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_Web_OrderActivity:
                Toast.makeText(OrderDetailActivity.this, "Btn Web", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_Email_OrderActivity:
                Toast.makeText(OrderDetailActivity.this, "Btn Email", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}