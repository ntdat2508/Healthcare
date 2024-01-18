package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class OrderDetail extends AppCompatActivity {
    private String[][] order_details = {};
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        btn = findViewById(R.id.buttonODBack);
        lst = findViewById(R.id.listViewOD);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderDetail.this, Home.class));
            }
        });

        DBHelper db = new DBHelper(getApplicationContext(), "healthcare", null, 1);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();
        ArrayList dbData = db.getOrderData(username);

        Date today = new Date();

        order_details = new String[dbData.size()][];
        for (int i=0; i<order_details.length; i++) {
            order_details[i] = new String[6];
            String arrData = dbData.get(i).toString();
            String[] strData = arrData.split(java.util.regex.Pattern.quote("$"));
            order_details[i][0] = strData[0];
            order_details[i][1] = strData[1];
            if (strData[7].compareTo("medicine")==0) {
                order_details[i][3] = "Lịch:"+ strData[4];
            } else {
                order_details[i][3] = "Lịch:"+ strData[4] + " "+ strData[5];
            }
            order_details[i][2] = "Giá: " + strData[6];
            order_details[i][4] = strData[7];

            order_details[i][5] = strData[4];
            try {
                Date dateInOrder = new SimpleDateFormat("dd-MM-YYYY").parse(order_details[i][5]);
                if (today.equals(dateInOrder)) {
                    Toast.makeText(getApplicationContext(), "Bạn có lịch hẹn ngày hôm nay", Toast.LENGTH_SHORT).show();
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        list = new ArrayList();
        for (int i=0; i<order_details.length; i++) {
            item = new HashMap<String, String>();
            item.put( "line1", order_details[i][0]);
            item.put( "line2", order_details[i][1]);
            item.put( "line3", order_details[i][2]);
            item.put( "line4", order_details[i][3]);
            item.put( "line5", order_details[i][4]);
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] {"line1", "line2", "line3", "line4", "line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        ListView lst = findViewById(R.id.listViewOD);
        lst.setAdapter(sa);
    }
}