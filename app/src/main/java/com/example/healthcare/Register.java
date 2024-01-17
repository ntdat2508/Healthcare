package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText edtRegUserName, edtRegEmail, edtRegPW, edtRegConfirmPW;
    Button btnReg;
    TextView tvLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtRegUserName = findViewById(R.id.edtRegUserName);
        edtRegEmail = findViewById(R.id.edtRegEmail);
        edtRegPW = findViewById(R.id.edtRegPW);
        edtRegConfirmPW = findViewById(R.id.edtRegConfirmPW);
        btnReg = findViewById(R.id.btnReg);
        tvLogin = findViewById(R.id.tvLogin);

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edtRegUserName.getText().toString();
                String email = edtRegEmail.getText().toString();
                String password = edtRegPW.getText().toString();
                String confirm = edtRegConfirmPW.getText().toString();
                DBHelper db = new DBHelper(getApplicationContext(),"healthcare",null,1);

                if (username.length()==0 || email.length()==0 ||
                        password.length()==0 || confirm.length()==0) {
                    Toast.makeText(getApplicationContext(),"Vui lòng điền đầy đủ thông tin!", Toast.LENGTH_SHORT).show();
                } else {
                    if (password.compareTo(confirm)==0) {
                        if (isValid(password)) {
                            db.register(username, email, password);
                            Toast.makeText(getApplicationContext(), "Đăng ký tài khoản thành công", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(Register.this, MainActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "Mật khẩu phải chứa ít nhất 8 ký tự gồm chữ cái, chữ số và ký tự đặc biệt", Toast.LENGTH_SHORT).show();
                        }
                    } else{
                        Toast.makeText(getApplicationContext(),"Mật khẩu không trùng khớp!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this, MainActivity.class));
            }
        });
    }

    public static boolean isValid( String password) {
        int f1=0, f2=0, f3=0;
        if (password.length() < 0) {
            return false;
        } else {
            for (int i=0; i<password.length(); i++) {
                if (Character.isLetter(password.charAt(i))) {
                    f1=1;
                }
            }

            for (int j=0; j<password.length(); j++) {
                if (Character.isDigit(password.charAt(j))) {
                    f2=1;
                }
            }

            for (int s=0; s<password.length(); s++) {
                char c = password.charAt(s);
                if (c>=33 && c<=46 || c==64) {
                    f3=1;
                }
            }

            if (f1==1 && f2==1 && f3==1) {
                return true;
            }
            return false;
        }
    }
}