package com.tuannguyen.text1;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class ManageActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    ArrayList<WorkPlan> arrWork=null;
    MyArrayAdapter adapter=null;
    ListView lvWork=null;

    ImageButton btnAdd;
    TextView tvWork;
    TextView tvMoney;
    TextView tvNow;

    /*Text View in LeftMenu*/
    TextView tvInfoBDH;
    TextView tvInfoOff;

    Calendar now;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        connected();

        int month=now.get(Calendar.MONTH)+1;
        int year=now.get(Calendar.YEAR);
        tvNow.setText("THÁNG "+month+" NĂM "+year);

        btnAdd.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        drawerToggle=new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);

        tvInfoBDH.setOnTouchListener(this);
        tvInfoOff.setOnTouchListener(this);
    }

    private void connected(){
        btnAdd=(ImageButton)findViewById(R.id.btnMainAdd);
        tvWork=(TextView)findViewById(R.id.edtCreateWork);
        tvMoney=(TextView)findViewById(R.id.edtCreateMoney);
        tvNow=(TextView)findViewById(R.id.tvManageNow);

        tvInfoOff=(TextView) findViewById(R.id.tvInfoOff);
        tvInfoBDH=(TextView) findViewById(R.id.tvInfoBDH);


        lvWork=(ListView)findViewById(R.id.lvWorks);
        arrWork=new ArrayList<WorkPlan>();
        adapter= new MyArrayAdapter(this, R.layout.activity_create_workin_month, arrWork);
        lvWork.setAdapter(adapter);

        now=Calendar.getInstance();

        drawerLayout=(DrawerLayout)findViewById(R.id.activity_manage_drawer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_action, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        switch (item.getItemId()) {
            case R.id.btnincome:
                Intent intent=new Intent(this, IncomeActivity.class);
                startActivity(intent);
                return true;
            case R.id.btnexpense:
                intent=new Intent(this, ExpenseActivity.class);
                startActivity(intent);
                return true;
            case R.id.btnNote:
                intent=new Intent(this, NotesActivity.class);
                startActivity(intent);
                return true;
            case R.id.btnStatistics:
                intent=new Intent(this, StatisticsActivity.class);
                startActivity(intent);
                return true;
            case R.id.btnMain:
                intent=new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        String work=tvWork.getText().toString();
        String money=tvMoney.getText().toString();

        if(work.equals("")){
            Toast.makeText(this, "Chưa có công viêc!", Toast.LENGTH_SHORT).show();
            return;
        }
        if(money.equals("")){
            Toast.makeText(this, "Chưa nhập số tiền dự chi!", Toast.LENGTH_SHORT).show();
            return;
        }
        WorkPlan emp=new WorkPlan();
        emp.setWork(work);
        emp.setMoney(money);
        arrWork.add(emp);

        adapter.notifyDataSetChanged();
        tvWork.setText("");
        tvMoney.setText("");

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (view.getId()){
            case R.id.tvInfoBDH:
                Intent intent=new Intent(this, InformationActivity.class);
                startActivity(intent);
                break;
            case R.id.tvInfoOff:
                intent=new Intent(this, InfoOfficeActivity.class);
                startActivity(intent);
                break;
        }
        return false;
    }
}
