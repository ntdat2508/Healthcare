package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LabTestDetail extends AppCompatActivity {

    TextView tvPackageName, tvTotalCost;
    EditText edDetails;
    Button btnAddToCart, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_detail);

        tvPackageName = findViewById(R.id.textViewLDPackageName);
        tvTotalCost = findViewById(R.id.textViewLDTotalCost);
        edDetails = findViewById(R.id.edtLDMultiLine);
        btnAddToCart = findViewById(R.id.btnLDAddToCart);
        btnBack = findViewById(R.id.btnLDGoBack);

        edDetails.setKeyListener(null);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Tổng tiền: "+ intent.getStringExtra("text3")+"vnđ/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetail.this, LabTest.class));
            }
        });

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3").toString());

                DBHelper db = new DBHelper(getApplicationContext(), "healthcare", null, 1);

                if (db.checkCart(username,product)==1) {
                    Toast.makeText(getApplicationContext(), "Sản phẩm đã tồn tại trong giỏ hàng", Toast.LENGTH_SHORT).show();
                } else {
                    db.addCart(username, product, price, "lab");
                    Toast.makeText(getApplicationContext(), "Đã thêm vào giỏ hàng", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetail.this, LabTest.class));
                }
            }
        });
    }
}