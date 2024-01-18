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

public class LabTestBook extends AppCompatActivity {
    EditText name, address, contact, pincode;
    Button btnBooking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);

        name = findViewById(R.id.edtLTBFullName);
        address = findViewById(R.id.edtLTBAddress);
        contact = findViewById(R.id.edtLTBContact);
        pincode = findViewById(R.id.edtLTBPinCode);
        btnBooking = findViewById(R.id.btnLTBBooking);

        Intent intent = getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");

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
                        date.toString(),
                        time.toString(),
                        Float.parseFloat(price[1].toString()), "gói");
                db.removeCart(username,"gói");
                Toast.makeText(getApplicationContext(), "Bạn đã đặt hàng thành công!", Toast.LENGTH_LONG).show();
                startActivity(new Intent(LabTestBook.this, Home.class));
            }
        });
    }
}