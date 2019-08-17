package com.androidwind.demo.test;

import la.xiong.androidquick.ui.mvp.BaseContract;
import la.xiong.androidquick.ui.mvp.BaseModel;
import la.xiong.androidquick.ui.mvp.BasePresenter;

/**
 * @author ddnosh
 * @website http://blog.csdn.net/ddnosh
 */
public interface WeatherContract {
    interface Model extends BaseModel {

    }

    interface View extends BaseContract.BaseView {
        void refreshView(WeatherData data);
        void showGanmao();
        void showWendu();
    }

    abstract class Presenter extends BasePresenter<View> {
        public abstract void initData();
        public abstract void getGanmao();
        public abstract void getWendu();
    }
}
