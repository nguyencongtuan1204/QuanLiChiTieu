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
 * {@link DayInMonthFragment.OnDayInMonthFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class DayInMonthFragment extends Fragment {

    private OnDayInMonthFragmentInteractionListener mListener;

    public DayInMonthFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        /*Cach bat su kien trong Fragment, Thong qua View*/
        View view =inflater.inflate(R.layout.fragment_day_in_month, container, false);

        ListView lvDaysInMonth=(ListView) view.findViewById(R.id.lvDAyInMonth);
        final ArrayList<Integer> daylist=new ArrayList<>();
        int days=DayinMonth(3,2018);
        for(int i=0; i<days;i++){
            int day=i+1;
            daylist.add(day);
        }
        ArrayAdapter<Integer> adapter=new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, daylist);
        lvDaysInMonth.setAdapter(adapter);

        //Hàm bắt sự kiện trong ListView: lsDaysInMonth
        lvDaysInMonth.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //int i chính là vị trí của item trong listView nhé!!
                int a=i+1;
                if(mListener!=null){
                    mListener.onItemPressed("Work in day "+a+" in month!!");
                }
            }
        });
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDayInMonthFragmentInteractionListener) {
            mListener = (OnDayInMonthFragmentInteractionListener) context;
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

    public interface OnDayInMonthFragmentInteractionListener {
        void onItemPressed(String context);
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
