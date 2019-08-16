package com.androidwind.demo.test;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.test.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class DemoActivityTest {

    private Context mTargetContext;

    @Before
    public void setUp() throws Exception {
        mTargetContext = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void onCreate() {
        try {
            ApplicationInfo applicationInfo = mTargetContext.getPackageManager().getApplicationInfo(mTargetContext.getPackageName(), PackageManager.GET_META_DATA);
            Bundle metaData = applicationInfo.metaData;
            int data = (int) metaData.get("test");

            assertEquals(123456, data);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}