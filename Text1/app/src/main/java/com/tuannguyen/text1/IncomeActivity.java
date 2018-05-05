package com.tuannguyen.text1;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class IncomeActivity extends AppCompatActivity implements DayInMonthFragment.OnDayInMonthFragmentInteractionListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_income);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        DayInMonthFragment dayInMonth=new DayInMonthFragment();
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.DayInMonth,dayInMonth);
        fragmentTransaction.commit();

        //Create DataBase for IncomeActivity
        SQLiteData db=new SQLiteData(this, "QuanLiChi.sqlite", null,1);

        //Create Table
        db.QueryData("CREATE TABLE IF NOT EXISTS ChiTieu(" +
                "Id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "CongViec VARCHAR, " +
                "SoLuong INTEGER, " +
                "DonGia INTEGER, " +
                "ThanhTien INTERGER)");
    }

    @Override
    public void onItemPressed(String context) {
        WorkInDayFragment workInDayFragment = WorkInDayFragment.newInstance(context);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.WorkInDay, workInDayFragment);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
