package com.tuannguyen.text1;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class InformationActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnHouse1;
    Button btnHouse2;
    Button btnHouse3;
    Button btnHouse4;
    Button btnHouse5;

    nha1_fragment nha1Fragment=new nha1_fragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);


        connected();
        getDefault();

        /*ham mac dinh*/


        btnHouse1.setOnClickListener(this);
        btnHouse2.setOnClickListener(this);
        btnHouse3.setOnClickListener(this);
        btnHouse4.setOnClickListener(this);
        btnHouse5.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
    private void connected(){
        btnHouse1=(Button)findViewById(R.id.btnHouse1);
        btnHouse2=(Button)findViewById(R.id.btnHouse2);
        btnHouse3=(Button)findViewById(R.id.btnHouse3);
        btnHouse4=(Button)findViewById(R.id.btnHouse4);
        btnHouse5=(Button)findViewById(R.id.btnHouse5);
    }

    @Override
    public void onClick(View view) {
        BaseBackgraound();
        int btnColor=ContextCompat.getColor(this, R.color.textColorChoise);
        int textColor=ContextCompat.getColor(this, R.color.colorPrimary);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        switch (view.getId()){
            case R.id.btnHouse1:
                btnHouse1.setBackgroundColor(btnColor);
                btnHouse1.setTextColor(textColor);
                nha1_fragment nha1Fragment=new nha1_fragment();
                fragmentTransaction.replace(R.id.houseFragment,nha1Fragment);
                fragmentTransaction.commit();
                break;
            case R.id.btnHouse2:
                btnHouse2.setBackgroundColor(btnColor);
                btnHouse2.setTextColor(textColor);
                nha2_fragment nha2Fragment=new nha2_fragment();
                fragmentTransaction.replace(R.id.houseFragment,nha2Fragment);
                fragmentTransaction.commit();
                break;
            case R.id.btnHouse3:
                btnHouse3.setBackgroundColor(btnColor);
                btnHouse3.setTextColor(textColor);
                nha3_fragment nha3Fragment=new nha3_fragment();
                fragmentTransaction.replace(R.id.houseFragment,nha3Fragment);
                fragmentTransaction.commit();
                break;
            case R.id.btnHouse4:
                btnHouse4.setBackgroundColor(btnColor);
                btnHouse4.setTextColor(textColor);
                nha4_fragment nha4Fragment=new nha4_fragment();
                fragmentTransaction.replace(R.id.houseFragment,nha4Fragment);
                fragmentTransaction.commit();
                break;
            case R.id.btnHouse5:
                btnHouse5.setBackgroundColor(btnColor);
                btnHouse5.setTextColor(textColor);
                nha5_fragment nha5Fragment=new nha5_fragment();
                fragmentTransaction.replace(R.id.houseFragment,nha5Fragment);
                fragmentTransaction.commit();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_info_houses,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            case R.id.saveInfo:
                nha1Fragment.SaveInfoHouse1();
//                nha1Fragment.setInfoHouse1();
                Toast.makeText(this, "Lưu thông tin ban điều hành các nhà lại!!", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    public void BaseBackgraound(){
        int color= ContextCompat.getColor(this, R.color.colorPrimary);
        int textColor=ContextCompat.getColor(this, R.color.textColorChoise);

        btnHouse1.setBackgroundColor(color);
        btnHouse1.setTextColor(textColor);

        btnHouse2.setBackgroundColor(color);
        btnHouse2.setTextColor(textColor);

        btnHouse3.setBackgroundColor(color);
        btnHouse3.setTextColor(textColor);

        btnHouse4.setBackgroundColor(color);
        btnHouse4.setTextColor(textColor);

        btnHouse5.setBackgroundColor(color);
        btnHouse5.setTextColor(textColor);
    }

    private void getDefault(){
        int btnColor=ContextCompat.getColor(this, R.color.textColorChoise);
        int textColor=ContextCompat.getColor(this, R.color.colorPrimary);
        btnHouse1.setBackgroundColor(btnColor);
        btnHouse1.setTextColor(textColor);
        nha1_fragment nha1Fragment=new nha1_fragment();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.houseFragment,nha1Fragment);
        fragmentTransaction.commit();
    }
}