package com.androidwind.demo.test;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class WeatherActivityTest {
    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            WeatherActivity.class);
    @Test
    public void runClick(){
        onView(withText("点击获取城市感冒指数")).perform(click());
        onView(withId(R.id.wendu)).check(matches(withText("点击获取城市今天温度")));
    }
}
