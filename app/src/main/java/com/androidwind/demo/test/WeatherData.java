package com.androidwind.demo.test;

import java.util.List;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class WeatherData extends ResponseDataBean<WeatherData.DataBean> {

    public static final class DataBean {
        public YesterdayBean yesterday;
        public String city;
        public List<ForecastBean> forecast;
        public String ganmao;
        public String wendu;
    }

    public static final class YesterdayBean {
        public String date;
        public String high;
        public String fx;
        public String low;
        public String fl;
        public String type;
    }

    public static final class ForecastBean {
        public String date;
        public String high;
        public String fengli;
        public String low;
        public String fengxiang;
        public String type;
    }
}
