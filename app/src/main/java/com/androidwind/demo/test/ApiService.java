package com.androidwind.demo.test;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public interface ApiService {

    @GET("weather_mini")
    Observable<WeatherData> getWeather(@QueryMap Map<String, String> queryMap);

}
