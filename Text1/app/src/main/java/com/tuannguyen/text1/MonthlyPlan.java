package com.tuannguyen.text1;

/**
 * Created by AD on 4/27/2018.
 */

public class MonthlyPlan {
    private int month;
    private int year;

    public MonthlyPlan(int month, int year){
        this.month=month;
        this.year=year;
    }

    public void setMonth(int month){
        this.month=month;
    }
    public int getMonth(){
        return month;
    }
    public void setYear(int year){
        this.year=year;
    }
    public int getYear(){
        return year;
    }
    public String toString(){
        String str="Tháng "+month+" năm "+year;
        return str;
    }

}
