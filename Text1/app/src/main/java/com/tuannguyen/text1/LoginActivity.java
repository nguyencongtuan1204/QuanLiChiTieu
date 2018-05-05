package com.tuannguyen.text1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private EditText edtHouse;
    private EditText edtUserName;
    private EditText edtPassword;

    private Button btnSignIn;
    private Button btnCreateAccount;

    private String VALUE_USER_NAME="";
    private String VALUE_PASSWORK="";
    private int VALUE_FLAG=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        connectView();

        String SaveHouse= sharedPreferences.getString("house","");
        edtHouse.setText(SaveHouse);

        /*Vẫn nghĩ việc đánh dấu đã có tài khoản nên xảy ra tại đây,
        nên sẽ suy nghĩ thêm về cách vận hành thứ tự chạy của ứng dụng*/
        btnSignIn.setOnClickListener(this);
        btnCreateAccount.setOnClickListener(this);


    }

    private void connectView(){
        edtHouse=(EditText)findViewById(R.id.edtHouse);
        edtUserName=(EditText)findViewById(R.id.edtUserName);
        edtPassword=(EditText) findViewById(R.id.edtPassword);

        btnSignIn=(Button)findViewById(R.id.btnSignIn);
        btnCreateAccount=(Button)findViewById(R.id.btnCreateAccount);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor=sharedPreferences.edit();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSignIn:
                signIn();
                break;
            case R.id.btnCreateAccount:
                reguster();
                break;
        }
    }
    protected void signIn(){

        VALUE_USER_NAME = sharedPreferences.getString("UserName","");
        VALUE_PASSWORK = sharedPreferences.getString("Passwork","");

        String house=edtHouse.getText().toString();
        editor.putString("house", house);

        boolean error=false;

        String UserName = edtUserName.getText().toString().trim();
        String Passwork = edtPassword.getText().toString().trim();
        String House= edtHouse.getText().toString().trim();

        edtHouse.setText(House);

        if(!UserName.equals(VALUE_USER_NAME)){
            edtUserName.requestFocus();
            edtUserName.setError(this.getResources().getString(R.string.ErrorUserName));
            error=true;
        }
        if(!Passwork.equals(VALUE_PASSWORK)){
            edtPassword.requestFocus();
            edtPassword.setError(this.getResources().getString(R.string.ErrorPasswork));
            error=true;
        }
        if(!error){
            /*Ở đây vNx chư xử lí được cạch không cho tạo tài khoản mới khi máy đã có tài khoản rồi
            * bị tình trạng nếu tắt ứng dụng đi thì khi khởi động lại nó tiếp tục cho đăng kí tiếp.!!*/
            VALUE_FLAG=1;
            Intent intent=new Intent(this, ManageActivity.class);
            startActivity(intent);
        }
    }
    protected void reguster(){

        if(VALUE_FLAG==0){
            Intent intent=new Intent(this, InformationActivity.class);
            startActivityForResult(intent,0);
        }
        else {
            Toast.makeText(this, R.string.HadAccount, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0&&resultCode == Activity.RESULT_OK){
            String username=data.getStringExtra("KEY_USER_NAME");
            String passwork=data.getStringExtra("KEY_PASSWORK");
            int flag=data.getIntExtra("KEY_FLAG",0);

            editor.putString("UserName", username);
            editor.putString("Passwork", passwork);
            editor.putInt("Flag", flag);
            editor.commit();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
