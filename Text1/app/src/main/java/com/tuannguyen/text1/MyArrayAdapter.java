package com.tuannguyen.text1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by AD on 4/24/2018.
 */

public class MyArrayAdapter extends ArrayAdapter<WorkPlan> {
    Activity context=null;
    ArrayList<WorkPlan> myArray= null;
    int layoutId;

    public MyArrayAdapter(Activity context, int layoutId, ArrayList<WorkPlan> myArray){
        super(context, layoutId, myArray);
        this.context=context;
        this.layoutId=layoutId;
        this.myArray=myArray;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        convertView=inflater.inflate(layoutId, null);
        if(myArray.size()>0 && position>=0){
            final WorkPlan emp=myArray.get(position);

            final TextView tvWork=(TextView)convertView.findViewById(R.id.tvCreateWorktoWork);
            tvWork.setText(emp.getWork());

            final TextView tvMoney=(TextView)convertView.findViewById(R.id.tvCreateWorktoMoney);
            tvMoney.setText(emp.getMoney());
        }
        return convertView;
    }
}
