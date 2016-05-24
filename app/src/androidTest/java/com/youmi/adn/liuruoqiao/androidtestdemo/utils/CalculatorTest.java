package com.youmi.adn.liuruoqiao.androidtestdemo.utils;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.FixMethodOrder;

import org.junit.runners.MethodSorters;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//按照方法名的字典顺序进行排序。另外两个可选选项：MethodSorters.DEFAULT默认，使用hash值字典排序；MethodSorters.JVM：按JVM返回的方法名的顺序执行，顺序不可预测
public class CalculatorTest {

    private Calculator mCalculator;
    private static final String TAG = "CalculatorTest";

    /**
     * 在整个测试类一开始执行一次
     * 如果有一个类是负责对大文件（超过500兆）进行读写，它的每一个方法都是对文件进行操作。
     * 那么在调用每一个方法之前，都要打开一个大文件并读入文件内容，绝对是一个非常耗费时间的操作。
     * 如果@Before和@After，那么每次测试都要读取一次文件，效率及其低下。
     * 所有测试一开始读一次文件，所有测试结束之后释放文件，才是正解之道
     */
    @BeforeClass
    public static void beforeClass() {
        Log.i(TAG,"在整个测试类一开始执行一次，可声明整个测试类都需要的东西");
    }

    @AfterClass
    public static void afterClass() {
        Log.i(TAG,"在这个测试类结束后执行一次，回收资源");
    }

    @Before
    public void setUp() {
        mCalculator = new Calculator();
        Log.i(TAG,"在每个测试方法一开始都会执行一次");
    }

    @After
    public void tearDown() {
        Log.i(TAG,"在每个测试方法结束后都会执行一次");
    }

    @Test
    public void test001_addTwoNumbers() {
        double resultAdd = mCalculator.add(1d, 1d);
        assertThat(resultAdd, is(equalTo(2d)));
        Log.i(TAG,"第1个执行");
    }

    @Test
    public void test002_subTwoNumbers() {
        double resultSub = mCalculator.sub(1d, 1d);
        assertThat(resultSub, is(equalTo(0d)));
        Log.i(TAG,"第2个执行");
    }

    /**
     * 减法结果是负数
     */
    @Test
    public void test003_subWorksWithNegativeResult() {
        double resultSub = mCalculator.sub(1d, 17d);
        assertThat(resultSub, is(equalTo(-16d)));
        Log.i(TAG,"第3个执行");
    }

    @Test
    public void test004_divTwoNumbers() {
        double resultDiv = mCalculator.div(32d, 2d);
        assertThat(resultDiv, is(equalTo(16d)));
        Log.i(TAG,"第4个执行");
    }

    /**
     * 测试异常：如果一个函数应该抛出异常，但是它没抛出，这算不算Bug呢？这当然是Bug，异常测试的用途在于此
     * 除数为0，应该要抛出异常
     *
     */
    @Test(expected = IllegalArgumentException.class)
    public void test005_divDivideByZeroThrows() {
        mCalculator.div(32d, 0d);
        Log.i(TAG,"第5个执行");
    }

    @Test
    public void test006_mulTwoNumbers() {
        double resultMul = mCalculator.mul(32d, 2d);
        assertThat(resultMul, is(equalTo(64d)));
        Log.i(TAG,"第6个执行");
    }

    /**
     * 限时测试:给测试函数设定一个执行时间，超过了这个时间，就会被系统强行终止，并且汇报该函数结束的原因是因为超时
     *
     */
    //@Test(timeout = 1000)
    @Ignore
    public void test007_timeout(){
        //为了方便，直接在测试方法中进行一个耗时操作进行测试
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.i(TAG,"第7个执行");

    }

    /**
     * 添加此标签可以表明：此方法尚未完成，暂不参与此次测试
     * 以后需要进行测试的时候，可将标签更改
     */
    @Ignore
    public void test008_qiuyu(){

        //Log.i(TAG,"第8个执行");
    }
}