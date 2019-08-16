package com.androidwind.demo.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class DemoTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void isEmpty() {
        assertEquals(true, "".equals(""));
    }
}
