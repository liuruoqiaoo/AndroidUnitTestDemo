package com.youmi.adn.liuruoqiao.androidtestdemo.mock;

import com.youmi.adn.liuruoqiao.androidtestdemo.utils.Calculator;
import com.youmi.adn.liuruoqiao.androidtestdemo.utils.HttpRequest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MockTest {
    //创造一个mock对象
    @Mock
    HttpRequest mMockHttpRequest;

    private Calculator mCalculator;

    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    /**
     * mock对象使用常见场景：
     * 场景1：隔绝其他模块的开发状态。例：当需要请求外部服务器，而服务器的代码未实现的时候，可以先用mock对象模拟一个返回值
     * 场景2：隔绝其他模块出错引起本模块的测试错误。例：当被测试的方法无需考虑外部依赖的正确性，
     *       只要传递过来的数据是对的，那么方法给出的结果就要是对的，则可使用mock对象模拟传入的参数
     * 场景3：一些速度较慢的操作，可以用mock Object代替，快速返回
     * 场景4：异常逻辑，比如内存溢出、网络错误等
     * 场景4：用户的UI操作。因为UI很多时候都是用户行为触发事件，系统本身只是对这些触发事件进行响应，可以对这类UI做Mock
     */
    @Test
    public void testTran(){
        //这行代码，它确保当你访问该Mock的某个方法时总是能够获得一个没有任何逻辑的直接就返回的结果。
        when(mMockHttpRequest.getExchangeRate()).thenReturn(0.17);
        double resultTran = mCalculator.tran(1d, mMockHttpRequest.getExchangeRate());
        assertThat(resultTran, is(equalTo(mMockHttpRequest.getExchangeRate())));

    }
}
