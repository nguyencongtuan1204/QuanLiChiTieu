package com.tuannguyen.text1;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class ExpenseActivity extends AppCompatActivity implements ExpenseDayInMonthFragment.OnExpenseDayInMonthFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        ExpenseDayInMonthFragment expenseDayInMonthFragment=new ExpenseDayInMonthFragment();
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.ExpenseDayinMonth,expenseDayInMonthFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onItemPressed(String content) {
        ExpenseWorkInDayFragment expenseWorkInDayFragment=new ExpenseWorkInDayFragment();
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.ExpenseWorkInDay, expenseWorkInDayFragment);
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
