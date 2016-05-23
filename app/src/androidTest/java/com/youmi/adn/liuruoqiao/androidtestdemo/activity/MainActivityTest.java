package com.youmi.adn.liuruoqiao.androidtestdemo.activity;

import android.support.test.filters.RequiresDevice;
import android.support.test.filters.SdkSuppress;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.youmi.adn.liuruoqiao.androidtestdemo.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by liuruoqiao on 2016/5/18.
 * 通过@Rule来获得activity
 */
@RunWith(AndroidJUnit4.class)
@SmallTest //在使用命令行进行测试时，可输入参数，则只运行smallTest的测试用例
@SdkSuppress(minSdkVersion = 18) //限制最小的sdk是18
@RequiresDevice()
public class MainActivityTest {
    private MainActivity mActivity;
    private EditText num1;
    private EditText num2;
    private Button add;
    private TextView result;

    /**
     * 简单来说，@Rule是为各个测试方法提供一些支持。
     * 具体来说，比如需要测试一个Activity，那么可以在@Rule注解下面采用一个ActivityTestRule，该类提供了对相应Activity的功能测试的支持。
     * 该类可以在@Before和@Test标识的方法执行之前确保将Activity运行起来，并且在所有@Test和@After方法执行结束之后将Activity杀死。
     * 在整个测试期间，每个测试方法都可以直接对相应Activity进行修改和访问。
     * 如果需要测试service，还提供了ServiceTestRule
     */
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void setUp() throws Exception {
        mActivity=mActivityRule.getActivity();
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