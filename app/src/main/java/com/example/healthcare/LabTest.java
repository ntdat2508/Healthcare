package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTest extends AppCompatActivity {

    private String[][] packages = {
            {"Gói xét nghiệm 1 : Kiểm tra toàn thân", "", "", "", "999000"},
            {"Gói xét nghiệm 2 : Nhịn ăn đường huyết", "", "", "", "299000"},
            {"Gói xét nghiệm 3 : Kháng thể COVID-19 - IgG", "", "", "", "899000"},
            {"Gói xét nghiệm 4 : Kiểm tra tuyến giáp", "", "", "", "499000"},
            {"Gói xét nghiệm 5 : Kiểm tra miễn dịch", "", "", "", "699000"}
    };

    private String[] package_details = {
            "Nhịn ăn đường huyết\n" +
                    "Huyết đồ hoàn chỉnh\n" +
                    "HbA1c\n" +
                    "Kiểm tra chức năng thận\n" +
                    "Xét nghiệm đo hoạt độ LDH, Huyết thanh\n" +
                    "Hồ sơ lipid\n" +
                    "Kiểm tra chức năng gan",
            "Nhịn ăn đường huyết",
            "Kháng thể COVID_19 - IgG",
            "Tổng hồ sơ tuyến giáp (T3, T4 & TSH siêu nhạy cảm)",
            "Huyết đồ hoàn chỉnh\n" +
                    "CRP (C Protein phản ứng) Định lượng, Huyết thanh\n" +
                    "Nghiên cứu về sắt\n" +
                    "Kiểm tra chức năng thận\n" +
                    "Vitamin D Total-25 Hydroxy\n" +
                    "Kiểm tra chức năng gan\n" +
                    "Hồ sơ lipid"
    };

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGotoCart, btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGotoCart = findViewById(R.id.btnLDAddToCart);
        btnBack = findViewById(R.id.btnLDGoBack);
        listView = findViewById(R.id.listViewLT);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTest.this, Home.class));
            }
        });

        list = new ArrayList<>();
        for (int i=0; i< packages.length; i++) {
            item = new HashMap<String, String>();
            item.put( "line1", packages[i][0]);
            item.put( "line2", packages[i][1]);
            item.put( "line3", packages[i][2]);
            item.put( "line4", packages[i][3]);
            item.put( "line5", "Tổng tiền:" + packages[i][4] + "vnđ/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[] {"line1", "line2", "line3", "line4", "line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTest.this, LabTestDetail.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });

        btnGotoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTest.this,Cart.class));
            }
        });
    }
}