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

public class BuyMedic extends AppCompatActivity {
    private String[][] packages = {
            {"Uprise-D3 1000IU Capsule", "", "", "", "50000"},
            {"HealthVit Chromium Picolinate 200mcg Capsule", "", "", "", "305000"},
            {"Vitamin B Complex Capsules", "", "", "", "448000"},
            {"Inlife Vitamin E Wheat Germ Oil Capsule", "", "", "", "539000"},
            {"Dolo 650 Tablet", "", "", "", "30000"},
            {"Crocin 650 Advance Tablet", "", "", "", "50000"},
            {"Strepsils Medicated Lozenges for Sore Throat", "", "", "", "40000"},
            {"Tata 1mg Calcium + Vitamin D3", "", "", "", "30000"},
            {"Feronia -XT Tablet", "", "", "", "130000"},
    };

    private String[] package_details = {
            "Xây dựng và giữ cho xương và răng chắc khỏe\n" +
                    "Giảm mệt mỏi/Căng thẳng và đau cơ\n" +
                    "Tăng cường khả năng miễn dịch và tăng khả năng phục hồi chống lại nhiễm trùng",
            "Chromium là một khoáng chất vi lượng thiết yếu đóng vai trò quan trọng trong việc giúp điều hòa insulin",
            "Cung cấp sự giảm bớt sự thiếu hụt vitamin B\n" +
                    "Giúp hình thành hồng cầu\n" +
                    "Duy trì hệ thần kinh khỏe mạnh",
            "Nó tăng cường sức khỏe cũng như lợi ích cho làn da\n" +
                    "Nó giúp giảm vết thâm và sắc tố da\n" +
                    "nó có tác dụng bảo vệ da khỏi tia nắng mặt trời UVA và UVB khắc nghiệt",
            "Dolo 650 Tablet giúp giảm đau và hạ sốt bằng cách ngăn chặn sự giải phóng một số thông điệp hóa học",
            "Giúp hạ sốt và hạ nhiệt độ cao\n" +
                    "Bàn phù hợp cho người bị bệnh tim hoặc cao huyết áp",
            "Làm giảm các triệu chứng nhiễm trùng cổ họng do vi khuẩn và làm dịu quá trình phục hồi\n" +
                    "Mang lại cảm giác ấm áp và dễ chịu khi bị đau họng",
            "Giảm nguy cơ thiếu canxi, còi xương và loãng xương\n" +
                    "Thúc đẩy khả năng vận động và tính linh hoạt của khớp",
            "Giúp giảm tình trạng thiếu sắt do mất máu mãn tính hoặc do lượng sắt hấp thụ thấp"
    };

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medic);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.btnBMGoBack);
        btnGoToCart = findViewById(R.id.btnBMAddToCart);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedic.this, Home.class));
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedic.this, CartBuyMedic.class));
            }
        });

        list = new ArrayList<>();
        for (int i=0; i<packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Tổng tiền:" + packages[i][4] + "vnđ/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[] {R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(BuyMedic.this, BuyMedicDetail.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });
    }
}