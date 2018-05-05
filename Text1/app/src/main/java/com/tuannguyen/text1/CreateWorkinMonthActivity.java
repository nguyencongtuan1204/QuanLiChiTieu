package com.tuannguyen.text1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class CreateWorkinMonthActivity extends AppCompatActivity {

    TextView tvWork;
    TextView tvMoney;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workin_month);
    }
}
