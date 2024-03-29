package com.androidwind.demo.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import la.xiong.androidquick.module.network.retrofit.RetrofitManager;
import la.xiong.androidquick.module.rxjava.BaseConsumer;
import la.xiong.androidquick.tool.LogUtil;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public class WeatherPresenter extends WeatherContract.Presenter {

    private final String TAG = "WeatherPresenter";
    private Map<String, String> queryMap = new HashMap<>();
    public WeatherController controller = new WeatherController();

    @Override
    public void initData() {
        queryMap.put("city", "香港");
        addSubscribe(RetrofitManager.getInstance().createApi(ApiService.class)
                .getWeather(queryMap)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseConsumer<WeatherData>() {
                    @Override
                    public void onSuccess(WeatherData data) {
                        LogUtil.i(TAG, "success");
                        getView().refreshView(data);
                    }

                    @Override
                    public void onError() {

                    }
                }));
    }

    @Override
    public void getGanmao() {
        LogUtil.i(TAG, "getGanmao()");
        getView().showGanmao();
    }

    @Override
    public void getWendu() {
        LogUtil.i(TAG, "getWendu()");
        getView().showWendu();
    }

    @Override
    public void save() {
        LogUtil.i(TAG, "save()");
        controller.saveToSDCard();
    }

    public void setController(WeatherController controller) {
        LogUtil.i(TAG, "setController()");
        this.controller = controller;
    }

    public int getId() {
        return 100;
    }
}
