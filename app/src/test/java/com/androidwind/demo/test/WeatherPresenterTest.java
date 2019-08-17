package com.androidwind.demo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = 28)
public class WeatherPresenterTest {
    private WeatherPresenter presenter;
    private WeatherController controller;

    @Before
    public void setUp() {
        presenter = mock(WeatherPresenter.class);
        controller = mock(WeatherController.class);
    }

    @Test
    public void testRequest(){
        presenter.initData();
        verify(presenter).initData();
    }

    @Test
    public void testSave(){
        presenter = new WeatherPresenter();
        presenter.setController(controller);
        presenter.save();
        verify(controller).saveToSDCard();
    }
}
