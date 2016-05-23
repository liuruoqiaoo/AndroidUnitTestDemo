package com.youmi.adn.liuruoqiao.androidtestdemo.utils;

import static com.google.common.base.Preconditions.checkArgument;


public class Calculator {

    public enum Operator {ADD, SUB, DIV, MUL}

    /**
     * 加法操作
     */
    public double add(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    /**
     * 减法操作
     */
    public double sub(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    /**
     * 除法操作
     */
    public double div(double firstOperand, double secondOperand) {
        checkArgument(secondOperand != 0, "除数不可以等于0！");
        return firstOperand / secondOperand;
    }

    /**
     * 乘法操作
     */
    public double mul(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }

    public int mul(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }

    /**
     * 美元兑换操作
     */
    public double tran(double num, double exchangeRate) {
        return mul(num,exchangeRate);
    }

    /**
     * 求平方根
     */
    public int square(int n) {
        return mul(n, n);
    }

    /**
     * 求余
     */
    public int qiuyu(int firstOperand,int secondOperand) {
        //未完成的函数
        return 0;
    }
}