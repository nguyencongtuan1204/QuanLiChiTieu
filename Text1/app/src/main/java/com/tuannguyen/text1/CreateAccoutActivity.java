package com.tuannguyen.text1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateAccoutActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtCreateAccountUserName;
    private EditText edtCreateAccountPasswork;
    private EditText edtCreateAccountRepasswork;
    private Button btnCreateAccountSave;

    private boolean error=false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_accout);

        connectView();
        btnCreateAccountSave.setOnClickListener(this);

    }

    private void connectView(){
        edtCreateAccountUserName =(EditText)findViewById(R.id.edtCreateAccountUserName);
        edtCreateAccountPasswork = (EditText) findViewById(R.id.edtCreateAccountPasswork);
        edtCreateAccountRepasswork = (EditText) findViewById(R.id.edtCreateAccountRepasswork);
        btnCreateAccountSave= (Button)findViewById(R.id.btnCreateAccountSave);
    }

    private void CreateAccount(){
        String CreateAccountUserName= edtCreateAccountUserName.getText().toString().trim();
        String CreateAccountPasswork=edtCreateAccountPasswork.getText().toString().trim();
        String CreateAccountRepasswork=edtCreateAccountRepasswork.getText().toString().trim();

        if(TextUtils.isEmpty(CreateAccountPasswork)){
            edtCreateAccountPasswork.requestFocus();
            edtCreateAccountPasswork.setError(this.getResources().getString(R.string.Create_Account_Passwork_error));
            error=true;
        }
        if(CreateAccountUserName.length()<8){
            edtCreateAccountUserName.requestFocus();
            edtCreateAccountUserName.setError(this.getResources().getString(R.string.Create_Account_User_Name_error));
            error=true;
        }
        if(!CreateAccountRepasswork.equals(CreateAccountPasswork)){
            edtCreateAccountRepasswork.requestFocus();
            edtCreateAccountRepasswork.setError(this.getResources().getString(R.string.Create_Account_Repasswork_error));
            error=true;
        }
        if(!error){
            Intent intent=new Intent();
            intent.putExtra("KEY_USER_NAME", CreateAccountUserName);
            intent.putExtra("KEY_PASSWORK", CreateAccountPasswork);
            intent.putExtra("KEY_FLAG",1);
            setResult(Activity.RESULT_OK, intent);
            finish();
        }
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCreateAccountSave:
                CreateAccount();
                break;
        }
    }
}
