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

public class BuyMedicDetail extends AppCompatActivity {
    TextView tvPackageName, tvTotalCost;
    EditText edDetail;
    Button btnBack, btnAddToCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medic_detail);

        tvPackageName = findViewById(R.id.textViewBMDPackageName);
        tvTotalCost = findViewById(R.id.textViewBMDTotalCost);
        edDetail = findViewById(R.id.edtBMDMultiLine);
        edDetail.setKeyListener(null);
        btnBack = findViewById(R.id.btnBMDGoBack);
        btnAddToCart = findViewById(R.id.btnBMDAddToCart);

        Intent intent = getIntent();
        tvPackageName.setText(intent.getStringExtra("text1"));
        edDetail.setText(intent.getStringExtra("text2"));
        tvTotalCost.setText("Tổng tiền: "+ intent.getStringExtra("text3")+"vnđ/-");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicDetail.this, BuyMedic.class));
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
                    db.addCart(username, product, price, "medicine");
                    Toast.makeText(getApplicationContext(), "Thêm sản phẩm vào giỏ hàng thành công!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuyMedicDetail.this, BuyMedic.class));
                }
            }
        });

    }
}