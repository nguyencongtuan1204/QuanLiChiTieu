package com.tuannguyen.text1;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static android.app.DatePickerDialog.OnDateSetListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    TextView tvmain;
    ListView lvmain;
    ImageButton btnAdd;

    private ArrayList<Integer> listMonth;
    private ArrayList<Integer> listYear;
    private MonthLyAdapter adapter;
    private ArrayList<MonthlyPlan> arrayList;


    Calendar now;
    Calendar cal;
    Date dateFinish;
    String strDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connnected();
        innitData();
        getDefaultInfor();

        btnAdd.setOnClickListener(this);
    }

    private void connnected(){
        tvmain=(TextView) findViewById(R.id.tvMain);
        lvmain=(ListView)findViewById(R.id.lvMain);
        btnAdd=(ImageButton)findViewById(R.id.btnMainAdd);
    }

    private void innitData(){
        now=Calendar.getInstance();
        listYear=new ArrayList<Integer>();
        listMonth=new ArrayList<Integer>();
        arrayList=new ArrayList<MonthlyPlan>();
    }

    public void getDefaultInfor() {
        //lấy ngày hiện tại của hệ thống
        cal=Calendar.getInstance();
        SimpleDateFormat dft=null;
        //Định dạng ngày / tháng /năm
        dft=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        strDate=dft.format(cal.getTime());
        //hiển thị lên giao diện
        dateFinish=cal.getTime();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnMainAdd:
                showDatePickerDialog();
                break;
        }
    }

    public void showDatePickerDialog(){
        OnDateSetListener callBack=new OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int MonthOfYear, int DayOfMonth) {
                addData(MonthOfYear+1, listMonth, year, listYear);
            }
        };
        String s=strDate+"";
        String strArrtmp[]=s.split("/");
        int ngay=Integer.parseInt(strArrtmp[0]);
        int thang=Integer.parseInt(strArrtmp[1])-1;
        int nam=Integer.parseInt(strArrtmp[2]);
        DatePickerDialog pic=new DatePickerDialog(
                MainActivity.this,
                callBack, nam, thang, ngay);
        pic.setTitle("Chọn tháng cần quản lí");
        pic.show();
    }
    private void addData(int month, ArrayList<Integer> listMonth, int year, ArrayList<Integer> listYear){
        if(isMonth(month, listMonth)&&isYear(year, listYear)){
            Toast.makeText(this,"Đã tạo quản lí tháng!", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            tvmain.setText("");
            listMonth.add(month);
            listYear.add(year);
            MonthlyPlan monthlyPlan=new MonthlyPlan(month,year);
            arrayList.add(monthlyPlan);
            adapter=new MonthLyAdapter(this, R.layout.activity_month_contact, arrayList) {
                @Override
                public long getItemId(int i) {
                    return 0;
                }
            };
            lvmain.setAdapter(adapter);
        }
    }
    private boolean isMonth(int month, ArrayList<Integer> listMonth){
        int sizeList=listMonth.size();
        if(sizeList==0) return false;
        for(int i=0; i<sizeList;i++){
            if(month==listMonth.get(i)) return true;
        }
        return false;
    }
    private boolean isYear(int year, ArrayList<Integer> listYear){
        int sizeList=listYear.size();
        if(sizeList==0) return false;
        for(int i=0; i<sizeList;i++){
            if(year==listYear.get(i)) return true;
        }
        return false;
    }
}
