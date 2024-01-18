package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetail extends AppCompatActivity {
    private String[][] doctor_detail1 =
            {
                    {"Tên bác sĩ : Nguyễn Văn A", "Địa chỉ : Hà Nội", "Kinh nghiệm : 5 năm", "SĐT: 0123456789", "200000"},
                    {"Tên bác sĩ : Nguyễn Văn B", "Địa chỉ : Hoà Bình ", "Kinh nghiệm : 3 năm", "SĐT: 0123456789", "400000"},
                    {"Tên bác sĩ : Nguyễn Văn C", "Địa chỉ : Hưng Yên", "Kinh nghiệm : 2 năm", "SĐT: 0123456789", "200000"},
                    {"Tên bác sĩ : Nguyễn Văn D", "Địa chỉ : Thái Bình", "Kinh nghiệm : 6 năm", "SĐT: 0123456789", "500000"},
                    {"Tên bác sĩ : Nguyễn Văn E", "Địa chỉ : Hà Nội", "Kinh nghiệm : 7 năm", "SĐT: 0123456789", "300000"},
            };
    private String[][] doctor_detail2 =
            {
                    {"Tên bác sĩ : Nguyễn Văn A", "Địa chỉ : Hà Nội", "Kinh nghiệm : 5 năm", "SĐT: 0123456789", "200000"},
                    {"Tên bác sĩ : Nguyễn Văn B", "Địa chỉ : Hoà Bình ", "Kinh nghiệm : 3 năm", "SĐT: 0123456789", "400000"},
                    {"Tên bác sĩ : Nguyễn Văn C", "Địa chỉ : Hưng Yên", "Kinh nghiệm : 2 năm", "SĐT: 0123456789", "200000"},
                    {"Tên bác sĩ : Nguyễn Văn D", "Địa chỉ : Thái Bình", "Kinh nghiệm : 6 năm", "SĐT: 0123456789", "500000"},
                    {"Tên bác sĩ : Nguyễn Văn E", "Địa chỉ : Hà Nội", "Kinh nghiệm : 7 năm", "SĐT: 0123456789", "300000"},
            };
    private String[][] doctor_detail3 =
            {
                    {"Tên bác sĩ : Nguyễn Văn A", "Địa chỉ : Hà Nội", "Kinh nghiệm : 5 năm", "SĐT: 0123456789", "200000"},
                    {"Tên bác sĩ : Nguyễn Văn B", "Địa chỉ : Hoà Bình ", "Kinh nghiệm : 3 năm", "SĐT: 0123456789", "400000"},
                    {"Tên bác sĩ : Nguyễn Văn C", "Địa chỉ : Hưng Yên", "Kinh nghiệm : 2 năm", "SĐT: 0123456789", "200000"},
                    {"Tên bác sĩ : Nguyễn Văn D", "Địa chỉ : Thái Bình", "Kinh nghiệm : 6 năm", "SĐT: 0123456789", "500000"},
                    {"Tên bác sĩ : Nguyễn Văn E", "Địa chỉ : Hà Nội", "Kinh nghiệm : 7 năm", "SĐT: 0123456789", "300000"},
            };
    private String[][] doctor_detail4 =
            {
                    {"Tên bác sĩ : Nguyễn Văn A", "Địa chỉ : Hà Nội", "Kinh nghiệm : 5 năm", "SĐT: 0123456789", "200000"},
                    {"Tên bác sĩ : Nguyễn Văn B", "Địa chỉ : Hoà Bình ", "Kinh nghiệm : 3 năm", "SĐT: 0123456789", "400000"},
                    {"Tên bác sĩ : Nguyễn Văn C", "Địa chỉ : Hưng Yên", "Kinh nghiệm : 2 năm", "SĐT: 0123456789", "200000"},
                    {"Tên bác sĩ : Nguyễn Văn D", "Địa chỉ : Thái Bình", "Kinh nghiệm : 6 năm", "SĐT: 0123456789", "500000"},
                    {"Tên bác sĩ : Nguyễn Văn E", "Địa chỉ : Hà Nội", "Kinh nghiệm : 7 năm", "SĐT: 0123456789", "300000"},
            };
    private String[][] doctor_detail5 =
            {
                    {"Tên bác sĩ : Nguyễn Văn A", "Địa chỉ : Hà Nội", "Kinh nghiệm : 5 năm", "SĐT: 0123456789", "200000"},
                    {"Tên bác sĩ : Nguyễn Văn B", "Địa chỉ : Hoà Bình ", "Kinh nghiệm : 3 năm", "SĐT: 0123456789", "400000"},
                    {"Tên bác sĩ : Nguyễn Văn C", "Địa chỉ : Hưng Yên", "Kinh nghiệm : 2 năm", "SĐT: 0123456789", "200000"},
                    {"Tên bác sĩ : Nguyễn Văn D", "Địa chỉ : Thái Bình", "Kinh nghiệm : 6 năm", "SĐT: 0123456789", "500000"},
                    {"Tên bác sĩ : Nguyễn Văn E", "Địa chỉ : Hà Nội", "Kinh nghiệm : 7 năm", "SĐT: 0123456789", "300000"},
            };
    TextView DDTitle;
    Button btnBack;
    String[][] doctor_detail = {};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_detail);

        DDTitle = findViewById(R.id.textViewDDTitle1);
        btnBack = findViewById(R.id.btnLDGoBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        DDTitle.setText(title);

        if(title.compareTo("Bác sĩ gia đình")==0) {
            doctor_detail = doctor_detail1;
        } else if(title.compareTo("Chuyên gia dinh dưỡng")==0) {
            doctor_detail = doctor_detail2;
        } else if(title.compareTo("Nha sĩ")==0) {
            doctor_detail = doctor_detail3;
        } else if(title.compareTo("Bác sĩ phẫu thuật")==0) {
            doctor_detail = doctor_detail4;
        } else if(title.compareTo("Bác sĩ tim mạch")==0) {
            doctor_detail = doctor_detail5;
        }

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetail.this, FindDoctor.class));
            }
        });

        list = new ArrayList();
        for (int i=0; i<doctor_detail.length; i++) {
            item = new HashMap<String, String>();
            item.put( "line1", doctor_detail[i][0]);
            item.put( "line2", doctor_detail[i][1]);
            item.put( "line3", doctor_detail[i][2]);
            item.put( "line4", doctor_detail[i][3]);
            item.put( "line5", "Giá:" + doctor_detail[i][4] + "vnđ/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
                );

        ListView lst = findViewById(R.id.listViewLT);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetail.this, Appointment.class);
                it.putExtra("text1", title);
                it.putExtra("text2", doctor_detail[i][0]);
                it.putExtra("text3", doctor_detail[i][1]);
                it.putExtra("text4", doctor_detail[i][3]);
                it.putExtra("text5", doctor_detail[i][4]);
                startActivity(it);
            }
        });
    }
}