package com.androidwind.demo.test;

import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.hamcrest.core.Is.is;
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
        activity.setPresenter(presenter);
    }

    @Test
    public void testWenduClick() {
        Button ganmao = activity.findViewById(R.id.ganmao);

        ganmao.performClick();

        verify(presenter).showTest1();
        // assertThat(ganmao.getText().toString(), is("点击获取城市感冒指数"));
    }
}
