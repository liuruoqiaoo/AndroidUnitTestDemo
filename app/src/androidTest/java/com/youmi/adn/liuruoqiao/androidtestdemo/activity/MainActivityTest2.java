package com.youmi.adn.liuruoqiao.androidtestdemo.activity;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.youmi.adn.liuruoqiao.androidtestdemo.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by liuruoqiao on 2016/5/18.
 * 通过继承ActivityInstrumentationTestCase2来获取activity
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest2  extends ActivityInstrumentationTestCase2<MainActivity>{
    private MainActivity mActivity;
    private EditText num1;
    private EditText num2;
    private Button add;
    private TextView result;
    public MainActivityTest2(){
        super(MainActivity.class);
    }
    @Before
    public void setUp() throws Exception {
        super.setUp();

        //可以使用InstrumentationRegistry获得相关的测试信息，比如测试app的context对象，被测app的context对象等
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());

        // getActivity()方法会在开始所有的testCase之前启动相应的Activity
        mActivity = getActivity();
        num1=(EditText)mActivity.findViewById(R.id.num1);
        num2=(EditText)mActivity.findViewById(R.id.num2);
        add=(Button)mActivity.findViewById(R.id.add);
        result=(TextView)mActivity.findViewById(R.id.result);

    }
    /**
     * @throws Exception
     * 资源回收
     */
    @After
    public void tearDown() throws Exception {
        mActivity.finish();
    }


    /**
     * 测试是否初始化完成
     */
    public void test_init(){
        assertNotNull(mActivity);
        assertNotNull(num1);
        assertNotNull(num2);
        assertNotNull(add);
        assertNotNull(result);

    }

    /**
     * @throws Exception
     * 测试加法操作
     */
    @Test
    public void test_add()throws Exception{
        //在主线程中设置
        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                num1.setText("5");
                num2.setText("6");
                add.performClick();
            }
        });
        Thread.sleep(500);
        assertEquals("5",num1.getText().toString());
        assertEquals("6",num2.getText().toString());
        assertEquals("11.0",result.getText().toString());
    }

}
