package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView exit = findViewById(R.id.cardFDback);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindDoctor.this, Home.class));
            }
        });

        CardView familyphysic = findViewById(R.id.cardFDFamilyPhysic);
        familyphysic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctor.this, DoctorDetail.class);
                it.putExtra("title", "Bác sĩ gia đình");
                startActivity(it);
            }
        });

        CardView dietician = findViewById(R.id.cardFDDiet);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctor.this, DoctorDetail.class);
                it.putExtra("title", "Chuyên gia dinh dưỡng");
                startActivity(it);
            }
        });

        CardView dentist = findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctor.this, DoctorDetail.class);
                it.putExtra("title", "Nha sĩ");
                startActivity(it);
            }
        });

        CardView surgeon = findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctor.this, DoctorDetail.class);
                it.putExtra("title", "Bác sĩ phẫu thuật");
                startActivity(it);
            }
        });

        CardView diologist = findViewById(R.id.cardFDDiologists);
        diologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctor.this, DoctorDetail.class);
                it.putExtra("title", "Bác sĩ tim mạch");
                startActivity(it);
            }
        });
    }
}