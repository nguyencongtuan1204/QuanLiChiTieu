package com.tuannguyen.text1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ExpenseWorkInDayFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_CONTENT = "content";

    // TODO: Rename and change types of parameters
    private String mContent;


    public ExpenseWorkInDayFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ExpenseWorkInDayFragment newInstance(String content){
        ExpenseWorkInDayFragment fragment = new ExpenseWorkInDayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CONTENT, content);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mContent = getArguments().getString(ARG_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_expense_work_in_day, container, false);

        TextView tvContent = (TextView) view.findViewById(R.id.tvExpense);
        if (!TextUtils.isEmpty(mContent)){
            tvContent.setText(mContent);
        }
        return view;
    }

}
