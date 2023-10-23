package com.example.mycafe_a189629;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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
        if(v.getId() == R.id.btn_Call_OrderActivity){
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel: 012345678"));

            if(callIntent.resolveActivity(getPackageManager()) == null){//verify whether the device can receive the following intent
                Toast.makeText(OrderDetailActivity.this, "Sorry, no App can handle this action and data", Toast.LENGTH_SHORT).show();
            }else{
                startActivity(callIntent);
            }

        }else if(v.getId() == R.id.btn_Web_OrderActivity){

            Uri webpage = Uri.parse("http://www.google.com");

            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);


            if(webIntent.resolveActivity(getPackageManager()) == null){//verify whether the device can receive the following intent
                Toast.makeText(OrderDetailActivity.this, "Sorry, no App can handle this action and data", Toast.LENGTH_SHORT).show();
            }else{
                startActivity(webIntent);
            }

        }else if(v.getId() == R.id.btn_Email_OrderActivity) {

            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your order from MyCafeApp");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message: Information about order");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mycafeapp@company.com"});


            if(emailIntent.resolveActivity(getPackageManager()) == null){//verify whether the device can receive the following intent
                Toast.makeText(OrderDetailActivity.this, "Sorry, no App can handle this action and data", Toast.LENGTH_SHORT).show();
            }else{
                startActivity(emailIntent);
            }
        }
    }
}