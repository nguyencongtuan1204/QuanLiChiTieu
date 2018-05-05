package com.tuannguyen.text1;

/**
 * Created by AD on 4/24/2018.
 */

public class WorkPlan {

    private String work;
    private String money;

    public void setWork(String work){
        this.work=work;
    }
    public String getWork(){
        return this.work;
    }
    public void setMoney(String money){
        this.money=money;
    }
    public String getMoney(){
        return this.money;
    }
    public int toInteger(){
        int number=0;
        int legStr=money.length();
        for(int i=0; i<legStr;i++){
            if(money.charAt(i)==' ') continue;
            number= number*10+getNumber(money.charAt(i));
        }
        return number;
    }
    private int getNumber(char ch){
        switch (ch){
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
            default: return 0;
        }
    }
}
