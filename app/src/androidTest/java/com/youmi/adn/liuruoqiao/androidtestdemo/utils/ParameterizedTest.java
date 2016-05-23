package com.youmi.adn.liuruoqiao.androidtestdemo.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by liuruoqiao on 2016/5/17.
 * 参数化测试：这个是JUnit4的一个优化，意在减少大量重复的代码
 * 测试“计算一个数的平方”这个函数，暂且分三类：正数、0、负数。
 * 只写一个测试函数，把这若干种情况作为参数传递进去，一次性的完成测试
 */
@RunWith(Parameterized.class)
public class ParameterizedTest {
    private static Calculator calculator = new Calculator();

    private int param;

    private int result;

    /**
     * 定义测试数据的集合
     */
    @Parameterized.Parameters
    public static Collection data() {
        return Arrays.asList(new Object[][]{
                {2, 4},//正数
                {0, 0},//零
                {-3, 9},//负数
        });

    }

    /**
     *
     *  构造函数，对变量进行初始化
     */
    public ParameterizedTest(int param, int result) {
        this.param = param;
        this.result = result;
    }

    @Test
    public void square() {
        int resultSub = calculator.square(5);
        assertThat(resultSub, is(equalTo(25)));
    }

}

