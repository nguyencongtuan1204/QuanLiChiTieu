package com.tuannguyen.text1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by AD on 5/2/2018.
 */

public class nha1_fragment extends Fragment {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    EditText edtNameTN1;
    EditText edtNumberTN1;
    ImageButton ibtnCallTN1;
    EditText edtNamePN1;
    EditText edtNumberPN1;
    ImageButton ibtnCallPN1;
    EditText edtNameQL1;
    EditText edtNumberQL1;
    ImageButton ibtnCallQL1;

    /*Button in ActivityMain*/
    Button btnSave;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.nha1, container, false);

        connected(view);


        ibtnCallTN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+edtNumberTN1.getText().toString()));
                startActivity(intent);

            }
        });
        ibtnCallPN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+edtNumberPN1.getText().toString()));
                startActivity(intent);
            }
        });
        ibtnCallQL1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+edtNumberQL1.getText().toString()));
                startActivity(intent);
            }
        });
        return view;
    }

    private void connected(View view){

        edtNameTN1=(EditText) view.findViewById(R.id.edtNameTN1);
        edtNamePN1=(EditText) view.findViewById(R.id.edtNamePN1);
        edtNameQL1=(EditText) view.findViewById(R.id.edtNameQL1);

        edtNumberTN1=(EditText) view.findViewById(R.id.edtNumberTN1);
        edtNumberPN1=(EditText) view.findViewById(R.id.edtNumberPN1);
        edtNumberQL1=(EditText) view.findViewById(R.id.edtNumberQL1);

        ibtnCallTN1=(ImageButton) view.findViewById(R.id.ibtnCallTN1);
        ibtnCallPN1=(ImageButton) view.findViewById(R.id.ibtnCallPN1);
        ibtnCallQL1=(ImageButton) view.findViewById(R.id.ibtnCallQL1);

        sharedPreferences = getActivity().getSharedPreferences("my_data", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public void SaveInfoHouse1(){
        String NameTN1=edtNameTN1.getText().toString();
        String NumberTN1=edtNumberTN1.getText().toString();
        String NamePN1=edtNamePN1.getText().toString();
        String NumberPN1=edtNumberPN1.getText().toString();
        String NameQL1=edtNameQL1.getText().toString();
        String NumberQL1=edtNumberQL1.getText().toString();
        editor.putString("nameTN1", NameTN1);
        editor.putString("numberTN1", NumberTN1);
        editor.putString("namePN1", NamePN1);
        editor.putString("numberPN1", NumberPN1);
        editor.putString("nameQL1", NameQL1);
        editor.putString("numberQL1", NumberQL1);
        editor.commit();
    }
    public void setInfoHouse1(){
        edtNameTN1.setText(sharedPreferences.getString("nameTN1",""));
        edtNumberTN1.setText(sharedPreferences.getString("numberTN1",""));
        edtNamePN1.setText(sharedPreferences.getString("namePN1",""));
        edtNumberPN1.setText(sharedPreferences.getString("numberPN1",""));
        edtNameQL1.setText(sharedPreferences.getString("nameQL1",""));
        edtNumberQL1.setText(sharedPreferences.getString("numberQL1",""));
    }
}
