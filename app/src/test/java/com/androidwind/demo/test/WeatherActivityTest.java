package com.androidwind.demo.test;

import android.content.Intent;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;
import org.robolectric.shadows.ShadowTextView;

import java.lang.reflect.Field;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = 28)
public class WeatherActivityTest {
    private WeatherActivity activity;
    private WeatherPresenter presenter;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(WeatherActivity.class);
        presenter = mock(WeatherPresenter.class);
        activity.setPresenter(presenter);//如果不用这种方式就要用反射获取private成员变量
    }

    @Test
    public void testGanmaoClick() {
        Button ganmao = activity.findViewById(R.id.ganmao);
        ganmao.performClick();
        verify(presenter).getGanmao();
        //如果不用activity.setPresenter(presenter)则使用下面代码
        // try {
        //     Field field = WeatherActivity.class.getSuperclass().getDeclaredField("mPresenter");
        //     field.setAccessible(true);
        //     field.set(activity, presenter);
        //     ganmao.performClick();
        //     verify(presenter).showTest2();
        // } catch (Exception e) {
        //     //error
        // }
        // verify(presenter).showTest1();
    }

    @Test
    public void testWenduClick() {
        Button wendu = activity.findViewById(R.id.wendu);
        wendu.performClick();
        assertThat(wendu.getText().toString(), is("点击获取城市今天温度"));
        assertEquals("验证温度", wendu.getText().toString(), "点击获取城市今天温度");
    }

    @Test
    public void testShadows() {
        TextView wendu = activity.findViewById(R.id.wendu);
        ShadowTextView stv = Shadows.shadowOf(wendu);
        assertEquals("验证温度示",stv.innerText(),"点击获取城市今天温度");
    }

    @Test
    public void testToSettingPage(){
        activity.toSettingPage();
        Intent expectedIntent = new Intent(activity, SettingActivity.class);
        Intent actualIntent = ShadowApplication.getInstance().getNextStartedActivity();
        Assert.assertEquals(expectedIntent.getComponent(), actualIntent.getComponent());
    }

    @Test
    public void testOnDestroy() {
        activity.initDestroy();
        verify(presenter).detachView();
    }
}
