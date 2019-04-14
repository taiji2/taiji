package com.steins.util;

/**
 * Created by Administrator on 2019/1/27.
 */
public class PageCalculator {
    public static int calculateRowIndex(int pageIndex,int pageSize){
        return (pageIndex>0)?(pageIndex-1)*pageSize:0;
    }
    public static int Pages(int count,int size){
        if (count%size==0){
            return (count/size);
        }
        else {
            return ((count/size)+1);
        }
    }
}
