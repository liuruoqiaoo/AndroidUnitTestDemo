package com.youmi.adn.liuruoqiao.androidtestdemo.utils;


public class MathUtil {
    public static int max(int a, int b, int c){
        if(a > b){
            if(a > c){
                return a;
            }else{
                return c;
            }
        }else{
            if(b > c){
                return b;
            }else{
                return c;
            }
        }
    }
}
