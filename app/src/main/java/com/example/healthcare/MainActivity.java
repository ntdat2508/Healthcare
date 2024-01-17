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

public class MainActivity extends AppCompatActivity {

    EditText edtLoginUserName, edtLoginPW;
    Button btnLogin;
    TextView tvNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLoginUserName = findViewById(R.id.edtRegUserName);
        edtLoginPW = findViewById(R.id.edtRegConfirmPW);
        btnLogin = findViewById(R.id.btnReg);
        tvNew = findViewById(R.id.tvLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtLoginUserName.getText().toString();
                String password = edtLoginPW.getText().toString();
                DBHelper db = new DBHelper(getApplicationContext(),"healthcare",null,1);

                if(username.length()==0 || password.length()==0) {
                    Toast.makeText(getApplicationContext(),"Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                } else {
                    if(db.login(username, password)==1) {
                        Toast.makeText(getApplicationContext(),"Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("username", username);
                        //save data with key and value
                        editor.apply();
                        startActivity(new Intent(MainActivity.this, Home.class));
                    } else {
                        Toast.makeText(getApplicationContext(),"Tên đăng nhập hoặc mật khẩu không hợp lệ!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tvNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });
    }
}