package com.tuannguyen.text1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ExpenseDayInMonthFragment.OnExpenseDayInMonthFragmentListener} interface
 * to handle interaction events.
 */
public class ExpenseDayInMonthFragment extends Fragment {

    private OnExpenseDayInMonthFragmentListener mListener;


    public ExpenseDayInMonthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_expense_day_in_month, container, false);

        ListView lvDayinMonthExp=(ListView) view.findViewById(R.id.lv_Expense_Day_In_Month);
        final ArrayList<Integer> dayslist=new ArrayList<>();
        int thang3=DayinMonth(3,2018);
        for(int i=0;i<thang3;i++){
            int day=i+1;
            dayslist.add(day);
        }
        ArrayAdapter<Integer> adapter=new ArrayAdapter<Integer>(getActivity(), android.R.layout.simple_list_item_1, dayslist);
        lvDayinMonthExp.setAdapter(adapter);

        lvDayinMonthExp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int day, long l) {
                int a=day+1;
                if(mListener!=null){
                    mListener.onItemPressed("Tong chi trong ngay "+a+":");
                }
            }
        });
        return view;
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnExpenseDayInMonthFragmentListener) {
            mListener = (OnExpenseDayInMonthFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnExpenseDayInMonthFragmentListener {
        // TODO: Update argument type and name
        void onItemPressed(String content);
    }
    public boolean NamNhuan(int year){
        if(year%400==0){
            return true;
        }
        else if(year%100==0){
            return false;
        }
        else if(year %4==0){
            return true;
        }
        else {
            return false;
        }
    }

    public int DayinMonth(int month, int year){
        switch (month){
            case 1:case 3:case 5:case 7:case 8:case 10:case 12:
                return 31;
            case 4:case 6:case 9:case 11:
                return 30;
            default:
                if (NamNhuan(year)) return 29;
                else return 28;
        }
    }
}
