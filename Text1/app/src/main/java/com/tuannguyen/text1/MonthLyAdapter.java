package com.tuannguyen.text1;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by AD on 4/27/2018.
 */

public abstract class MonthLyAdapter extends BaseAdapter{
   ArrayList<MonthlyPlan> arrMonthlyPlan;
   Activity context;
   int layoutId;

   public MonthLyAdapter(Activity context, int layoutId, ArrayList<MonthlyPlan> arrMonthlyPlan){
      this.context=context;
      this.arrMonthlyPlan=arrMonthlyPlan;
      this.layoutId=layoutId;
   }
   public int getCount(){
      return arrMonthlyPlan!=null?arrMonthlyPlan.size():0;
   }

   public Object getItem(int position){
      return arrMonthlyPlan.get(position);
   }
   public View getView(final int position, View convertView, ViewGroup parent){
      ViewHolder holder;
      if(convertView==null){
         holder=new ViewHolder();
         LayoutInflater inflater=context.getLayoutInflater();
         convertView=inflater.inflate(layoutId, null);
         holder.tvMonthlyPlan=(TextView)convertView.findViewById(R.id.tvMonthlyPlan);
         holder.ibtnExpense=(ImageButton)convertView.findViewById(R.id.ibtnExpense);
         holder.ibtnIncome=(ImageButton)convertView.findViewById(R.id.ibtnIncome);
         convertView.setTag(holder);
      }
      else {
         holder=(ViewHolder)convertView.getTag();
      }
      MonthlyPlan itemMonth=arrMonthlyPlan.get(position);
      holder.tvMonthlyPlan.setText(itemMonth.toString());
      holder.ibtnIncome.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Toast.makeText(context, "Goto IncomeActivity "+arrMonthlyPlan.get(position),Toast.LENGTH_SHORT).show();
         }
      });
      holder.ibtnExpense.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Toast.makeText(context, "Goto ExpenseActivity "+arrMonthlyPlan.get(position), Toast.LENGTH_SHORT).show();
         }
      });
      return convertView;
   }

   public class ViewHolder{
      private TextView tvMonthlyPlan;
      private ImageButton ibtnIncome;
      private ImageButton ibtnExpense;
   }
}
