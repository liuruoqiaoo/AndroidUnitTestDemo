package com.youmi.adn.liuruoqiao.androidtestdemo.activity;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.youmi.adn.liuruoqiao.androidtestdemo.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
/**
 * Created by liuruoqiao on 2016/5/18.
 * 白盒UI测试推荐使用Espresso
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityByEspresso {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);
    /**
     * 测试加法操作
     */
    @Test
    public void test_add(){
        onView(withId(R.id.num1)).perform(typeText("5"),closeSoftKeyboard());
        onView(withId(R.id.num2)).perform(typeText("6"),closeSoftKeyboard());
        onView(withId(R.id.add)).perform(click());
        onView(withId(R.id.result)).check(matches(withText("11.0")));

    }
}
