package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuyMedicBook extends AppCompatActivity {
    EditText name, address, contact, pincode;
    Button btnBooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medic_book);

        name = findViewById(R.id.edtBMBFullName);
        address = findViewById(R.id.edtBMBAddress);
        contact = findViewById(R.id.edtBMBContact);
        pincode = findViewById(R.id.edtBMBPinCode);
        btnBooking = findViewById(R.id.btnBMBBooking);

        Intent intent = getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                DBHelper db = new DBHelper(getApplicationContext(), "healthcare", null, 1);
                db.addOrder(username,
                        name.getText().toString(),
                        address.getText().toString(),
                        contact.getText().toString(),
                        Integer.parseInt(pincode.getText().toString()),
                        date.toString(),"",
                        Float.parseFloat(price[1].toString()), "thuốc");
                db.removeCart(username,"thuốc");
                Toast.makeText(getApplicationContext(), "Đơn hàng được đặt thành công!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(BuyMedicBook.this, Home.class));
            }
        });
    }
}