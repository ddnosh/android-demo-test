package com.androidwind.demo.test;

import android.app.Application;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.lang.reflect.Field;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = 28)
public class SettingActivityTest {

    private SettingActivity activity;
    private SettingController controller;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(SettingActivity.class);
        controller = mock(SettingController.class);
    }

    @Test
    public void testSettingClick() {
        Button toasting = activity.findViewById(R.id.toasting);
        toasting.performClick();
        try {//使用反射获取private成员变量, 否则在SettingActivity就得有个入口将SettingController实例传入
            Field field = WeatherActivity.class.getSuperclass().getDeclaredField("controller");
            field.setAccessible(true);
            field.set(activity, controller);
            toasting.performClick();
            verify(controller).getTitle();
        } catch (Exception e) {
            //error
        }
    }

    @Test
    public void testColor() {
        TextView toasting = activity.findViewById(R.id.toasting);
        Application application = RuntimeEnvironment.application;
        ColorStateList color = ColorStateList.valueOf(application.getResources().getColor(R.color.black));
        assertEquals("验证颜色", color, toasting.getTextColors());
    }

    @Test
    public void testVisibility() {
        TextView visible = activity.findViewById(R.id.visible);
        activity.hide();
        assertTrue("是否显示",visible.getVisibility()== View.GONE);
    }
}
