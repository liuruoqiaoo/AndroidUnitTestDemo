package com.youmi.adn.liuruoqiao.androidtestdemo;

import com.youmi.adn.liuruoqiao.androidtestdemo.utils.CalculatorTest;
import com.youmi.adn.liuruoqiao.androidtestdemo.utils.ParameterizedTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({CalculatorTest.class, ParameterizedTest.class})
public class TestSuite {
}
